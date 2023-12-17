package cin.ufpe.aps.AluCar.controllers;

import java.util.ArrayList;
import java.util.List;

import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Reserva;

public class ControleHistorico {


    public List<Reserva> obterHistorico() {
        Reservas reservas = new Reservas(null); // qual é a ideia desse parâmetro 
        return reservas.buscaHistorico(null);
    }

}
