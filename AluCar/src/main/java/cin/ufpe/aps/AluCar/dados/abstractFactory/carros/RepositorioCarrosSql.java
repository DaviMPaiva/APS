package cin.ufpe.aps.AluCar.dados.abstractFactory.carros;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAO;
import cin.ufpe.aps.AluCar.models.Car;

public class RepositorioCarrosSql implements IRepositorioCarros{

    private DatabaseDAO databaseDAO;

    public RepositorioCarrosSql (DatabaseDAO databaseDAO){
        this.databaseDAO = databaseDAO;
    }
    @Override
    public Car getCarro() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCarro'");
    }

    @Override
    public void setCarro(Car car) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");
    }
    
}
