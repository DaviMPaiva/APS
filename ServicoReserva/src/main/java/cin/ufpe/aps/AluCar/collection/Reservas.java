package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.proxy.*;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.IRepositorioReservas;
import cin.ufpe.aps.AluCar.models.*;

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
        return repoReserva.getReserva(usuario.getEmail());

    }

    @Override
    public void criaNovaReserva(Reserva reserva) {
        //adciona uma reserva ao banco de dados
        repoReserva.setReserva(reserva);
    }

	@Override
	public List<Reserva> validaReserva(Reserva reserva) {
        // make the queries
        List<Reserva> listaReserva = repoReserva.validaReserva(reserva);
        return listaReserva;
	}

    @Override
	public List<Reserva> validaAnyReserva(Reserva reserva) {
        // make the queries
        List<Reserva> listaReserva = repoReserva.validaAnyReserva(reserva);
        return listaReserva;
	}

    @Override
    public List<Reserva> getReservasMes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReservasMes'");
    }
}