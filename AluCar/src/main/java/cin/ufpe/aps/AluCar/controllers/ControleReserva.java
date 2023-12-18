package cin.ufpe.aps.AluCar.controllers;

import java.util.List;

import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.collection.Usuarios;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;
import cin.ufpe.aps.AluCar.models.Cartao;

public class ControleReserva {

    public boolean validaReserva(Reservas reservas, Reserva reserva) {
        //pega todas as reservas do carro e entre as dadas verificas
        //se der null então aceite, caso contrario rejeite
        return reservas.validaReserva(reserva);
    }

    public boolean realizaPagamento(Reserva reserva, Reservas reservas, Cartao cartao, Usuario usuario){
        //realiza o pagamento 
        //SalvaDadosCartao
        usuario.setCartao(cartao);
        //CriaNovaReserva
        reservas.criaNovaReserva(reserva);
        //EmailConfirmacao 
        return true;
    }

}
