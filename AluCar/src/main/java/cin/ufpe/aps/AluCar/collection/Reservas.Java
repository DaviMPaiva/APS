package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.proxy.*;

import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;

public class Reservas implements InterfaceReservas {

    @Override
    public float calculaTaxasAtraso() {
        // Implementação do cálculo de taxas de atraso
        return 0.0f; // Substitua isso com a lógica real
    }

    @Override
    public void registraPagamento() {
        // Implementação do registro de pagamento
        System.out.println("Pagamento registrado.");
    }

    @Override
    public void registraTaxas() {
        // Implementação do registro de taxas
        System.out.println("Taxas registradas.");
    }

    @Override
    public void buscaHistorico(Usuario usuario) {

        // Implementação da busca de histórico
        String email = usuario.getEmail();
        System.out.println(email);

    }

    @Override
    public void criaNovaReserva(Float valor, Car carro, Date dataInicio, Date dataTermino, Float taxa, Usuario usuario) {

      Reserva NovaReserva = new Reserva( null , valor, carro, dataInicio, dataTermino, taxa, usuario);

      System.out.println(NovaReserva.getValor());
    }

    @Override
    public Car pesquisaCarrosDisponiveis() {

        Carros carros = new Carros();

        Car carro = carros.PesquisaCarrosDisponiveis();

        return carro;

  }
}