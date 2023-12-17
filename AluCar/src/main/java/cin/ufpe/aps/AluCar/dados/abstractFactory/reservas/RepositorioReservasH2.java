package cin.ufpe.aps.AluCar.dados.abstractFactory.reservas;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.Reserva;

public class RepositorioReservasH2 implements IRepositorioReservas{

    private DatabaseDAOH2 databaseDAO;
    
    public RepositorioReservasH2(DatabaseDAOH2 databaseDAO){
        this.databaseDAO = databaseDAO;
    }
    @Override
    public Reserva getReserva() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReserva'");
    }

    @Override
    public void setReserva(Reserva reserva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReserva'");
    }
    
}
