package cin.ufpe.aps.AluCar.controllers;

import java.util.List;

import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;

public class ControleHistorico {


    public List<Reserva> obterHistorico(Reservas reservas, Usuario usuario) {
        return reservas.buscaHistorico(usuario);
    }

}
