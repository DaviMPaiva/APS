package cin.ufpe.aps.AluCar.dados.abstractFactory.reservas;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAO;
import cin.ufpe.aps.AluCar.models.Reserva;

public class RepositorioReservasSql implements IRepositorioReservas{

    private DatabaseDAO databaseDAO;
    
    public RepositorioReservasSql(DatabaseDAO databaseDAO){
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
