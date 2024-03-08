package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.proxy.*;
import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.dados.reservas.IRepositorioReservas;
import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Reservas implements InterfaceReservas {

    private IRepositorioReservas repoReserva;
    private List<Reserva> listaReserva;
    
    public Reservas(IRepositorioReservas repoReserva){
        this.repoReserva = repoReserva;
        
    }

    @Override
    public CarList pesquisaCarrosDisponiveis(Reserva reserva, Carros cars) {
        //pega todas as reservas para aquela data
        System.out.println(reserva.getDataInicio());

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Reserva>> response = restTemplate.exchange(
                "http://localhost:8082/reserva/getReservasSolicitadas/" + reserva.getDataInicio() + "/" + reserva.getDataTermino(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Reserva>>() {});
            listaReserva = response.getBody();
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