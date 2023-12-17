package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.proxy.*;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.IRepositorioReservas;
import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;
import java.util.List;

public class Reservas implements InterfaceReservas {

    private IRepositorioReservas repoReserva;
    
    public Reservas(IRepositorioReservas repoReserva){
        this.repoReserva = repoReserva;
    }

    @Override
    public float calculaTaxasAtraso() {
        // Implementação do cálculo de taxas de atraso
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");

    }

    @Override
    public void registraPagamento() {
        // Implementação do registro de pagamento
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");

    }

    @Override
    public void registraTaxas() {
        // Implementação do registro de taxas
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");

    }

    @Override
    public List<Reserva> buscaHistorico(Usuario usuario) {
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");

    }

    @Override
    public void criaNovaReserva(Float valor, Car carro, Date dataInicio, Date dataTermino, Float taxa, Usuario usuario) {

        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");

    }

    @Override
    public Car pesquisaCarrosDisponiveis() {

                throw new UnsupportedOperationException("Unimplemented method 'setCarro'");


  }
}