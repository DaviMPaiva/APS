package cin.ufpe.aps.AluCar.controllers;

import java.util.List;

import org.springframework.stereotype.Service;

import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;

@Service
public class ControleHistorico {


    public List<Reserva> obterHistorico(Reservas reservas, Usuario usuario) {
        return reservas.buscaHistorico(usuario);
    }

}
