package cin.ufpe.aps.AluCar.controllers;

import java.util.List;

import cin.ufpe.aps.AluCar.collection.Carros;
import cin.ufpe.aps.AluCar.collection.Reservas;
import cin.ufpe.aps.AluCar.collection.Usuarios;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;
import cin.ufpe.aps.AluCar.subsistemas.EmailService;
import cin.ufpe.aps.AluCar.models.Car;
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
    
    public Car getCarroPorPlaca(Carros carros, String placa) {
        return carros.getCarroPorPlaca(placa);
    }

    public boolean realizaPagamento(Reserva reserva, Reservas reservas, Cartao cartao, Usuario usuario, EmailService emailService){
        //realiza o pagamento 
        //SalvaDadosCartao
        System.out.println("\nSetando Cartão");
        usuario.setCartao(cartao);
        System.out.println("\nCartão setado\nCriando Reserva");
        //CriaNovaReserva
        reservas.criaNovaReserva(reserva);
        System.out.println("\nReserva Criada\nEnviando Email");
        //EmailConfirmacao 
        emailService.enviarEmail(usuario.getEmail());
        System.out.println("\nEmail Enviado");
        return true;
    }

}
