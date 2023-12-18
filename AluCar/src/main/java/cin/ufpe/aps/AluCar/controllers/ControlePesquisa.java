package cin.ufpe.aps.AluCar.controllers;

import java.util.List;

import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.collection.Carros;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;
import cin.ufpe.aps.AluCar.proxy.InterfaceReservas;
import cin.ufpe.aps.AluCar.models.Car;

public class ControlePesquisa {


    public List<Car> pesquisaModelo(Carros carros, String modelo) {
        return carros.PesquisaCarrosModelo(modelo);
    }

    public CarList pesquisaCarrosDisponiveis(InterfaceReservas reservas, Reserva reserva, Carros cars) {
        return reservas.pesquisaCarrosDisponiveis(reserva, cars);
    }

}