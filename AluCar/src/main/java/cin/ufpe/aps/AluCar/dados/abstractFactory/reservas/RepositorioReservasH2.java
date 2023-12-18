package cin.ufpe.aps.AluCar.dados.abstractFactory.reservas;

import java.sql.Date;
import java.util.List;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.Reserva;

public class RepositorioReservasH2 implements IRepositorioReservas{

    private DatabaseDAOH2 databaseDAO;
    
    public RepositorioReservasH2(DatabaseDAOH2 databaseDAO){
        this.databaseDAO = databaseDAO;
    }
    @Override
    public List<Reserva> getReserva(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReserva'");
    }

    @Override
    public void setReserva(Reserva reserva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReserva'");
    }
    @Override
    public List<Reserva> validaReserva(Reserva reserva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validaReserva'");
    }
    @Override
    public List<Reserva> validaAnyReserva(Reserva reserva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validaAnyReserva'");
    }
    @Override
    public List<Reserva> GetReservaMes(Date dataAtual, Date dataProximoMes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetReservaMes'");
    }
    
}
