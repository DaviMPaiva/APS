package cin.ufpe.aps.AluCar.controllers;

import java.util.ArrayList;
import java.util.List;

import cin.ufpe.aps.AluCar.Iterator.CarIterator;
import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.collection.Carros;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;
import cin.ufpe.aps.AluCar.proxy.InterfaceReservas;
import cin.ufpe.aps.AluCar.models.Car;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControlePesquisa {


    public List<Car> pesquisaModelo(Carros carros, String modelo) {
        return carros.PesquisaCarrosModelo(modelo);
    }

    public List<Car> pesquisaCarrosDisponiveis(InterfaceReservas reservas, Reserva reserva, Carros cars, Usuario usuario) {
        List<Car> carReturnList = new ArrayList<>();
        CarList carList = reservas.pesquisaCarrosDisponiveis(reserva, cars);
        CarIterator carIterator = carList.createIterator(usuario);
        while (carIterator.hasNext()) {
            Car car = carIterator.next();
            // Process the car (e.g., print details)
            carReturnList.add(car);
        }
        return carReturnList;
    }

    public Car getCarroPorPlaca(Carros carros, String placa) {
        return carros.getCarroPorPlaca(placa);
    }

}