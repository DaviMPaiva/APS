package cin.ufpe.aps.AluCar.controllers;

import java.util.List;

import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.collection.Usuarios;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;
import cin.ufpe.aps.AluCar.subsistemas.EmailService;
import cin.ufpe.aps.AluCar.models.Cartao;

public class ControleReserva {

    public boolean validaReserva(Reserva reserva, Reservas reservas, Cartao cartao, Usuario usuario, EmailService emailService) {
        //pega todas as reservas do carro e entre as dadas verificas
        //se der null então aceite, caso contrario rejeite
        List<Reserva> listaReserva = reservas.validaReserva(reserva);
        if (listaReserva == null || listaReserva.isEmpty()) {
            return this.realizaPagamento(reserva, reservas, cartao, usuario, emailService);
        }else{
            return false;
        }
    }

    public boolean realizaPagamento(Reserva reserva, Reservas reservas, Cartao cartao, Usuario usuario, EmailService emailService){
        //realiza o pagamento 
        //SalvaDadosCartao
        usuario.setCartao(cartao);
        //CriaNovaReserva
        reservas.criaNovaReserva(reserva);
        //EmailConfirmacao 
        emailService.enviarEmail(usuario.getEmail());
        return true;
    }

}
