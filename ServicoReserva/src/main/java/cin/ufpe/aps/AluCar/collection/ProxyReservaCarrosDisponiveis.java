package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.proxy.*;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.IRepositorioReservas;
import cin.ufpe.aps.AluCar.models.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProxyReservaCarrosDisponiveis implements InterfaceReservas {

    private IRepositorioReservas repoReserva;
    private List<Reserva> cache_reservas;
    private Date currentDate;
    private Date futureDate;

    public ProxyReservaCarrosDisponiveis(IRepositorioReservas repoReserva){
        this.repoReserva = repoReserva;
        this.MakeCache();
    }

    @Override
    public List<Reserva> getReservasMes(){
        return this.cache_reservas;
    }
    
    public void MakeCache(){
        // Get the current date
        LocalDate currentDateL = LocalDate.now();

        // Get the date 30 days from now
        LocalDate futureDateL = currentDateL.plusDays(30);

        // Define the desired date format
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convert dates to strings in the specified format
        this.currentDate = Date.valueOf(dateFormat.format(currentDateL));
        this.futureDate = Date.valueOf(dateFormat.format(futureDateL));

        //pega todas as reservas para o proximo mes
        this.cache_reservas = repoReserva.GetReservaMes(this.currentDate,this.futureDate);
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
    public void criaNovaReserva(Reserva reserva) {
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");
    }

	@Override
	public List<Reserva> validaReserva(Reserva reserva) {
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");
	}

    @Override
	public List<Reserva> validaAnyReserva(Reserva reserva) {
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");
	}
}