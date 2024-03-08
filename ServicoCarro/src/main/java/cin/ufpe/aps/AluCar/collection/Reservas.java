package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.proxy.*;
import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.dados.reservas.IRepositorioReservas;
import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reservas implements InterfaceReservas {

    private IRepositorioReservas repoReserva;
    
    public Reservas(IRepositorioReservas repoReserva){
        this.repoReserva = repoReserva;
    }

    @Override
    public CarList pesquisaCarrosDisponiveis(Reserva reserva, Carros cars) {
        //pega todas as reservas para aquela data
        System.out.println(reserva.getDataInicio);
        System.out.println(Date.valueOf(reserva.getDataInicio));

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Car>> response = restTemplate.exchange(
                url + "/reserva/getReservasSolicitadas/" + reserva.getDataInicio + "/" + reserva.getDataTermino,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Reserva>>() {});
            List<Reserva> listaReserva = response.getBody();
            System.out.println(carList);
            return carList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        //List<Reserva> listaReserva = repoReserva.validaAnyReserva(reserva);
        //pega todos os carros nessas reservas
        Set<String> carroSet = new HashSet<>();

        //pega os carros sem repeticao
        for (Reserva res : listaReserva) {
            carroSet.add(res.getCarro());
        }

        //passa os carros e o usario para a classe de carros fazer um interator
        CarList carros = cars.pesquisaCarrosDisponiveis(carroSet);

        return carros;
    }
}