package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.proxy.*;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.IRepositorioReservas;
import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<Car> pesquisaCarrosDisponiveis(Reserva reserva, Carros cars) {
        //pega todas as reservas para aquela data
        List<Reserva> listaReserva = repoReserva.validaAnyReserva(reserva);
        //pega todos os carros nessas reservas
        Set<String> carroSet = new HashSet<>();

        //pega os carros sem repeticao
        for (Reserva res : listaReserva) {
            carroSet.add(res.getCarro());
        }

        //passa os carros e o usario para a classe de carros fazer um interator
        List<Car> carros = cars.pesquisaCarrosDisponiveis(carroSet);

        return carros;
    }

	@Override
	public List<Reserva> validaReserva(Reserva reserva) {
        // make the queries
        List<Reserva> listaReserva = repoReserva.validaReserva(reserva);
        return listaReserva;
	}
}