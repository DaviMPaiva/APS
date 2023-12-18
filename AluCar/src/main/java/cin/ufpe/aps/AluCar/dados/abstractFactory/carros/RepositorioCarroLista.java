package cin.ufpe.aps.AluCar.dados.abstractFactory.carros;

import java.sql.SQLException;
import java.util.List;

import cin.ufpe.aps.AluCar.models.Car;

public class RepositorioCarroLista implements IRepositorioCarros{

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

    @Override
    public List<Car> getCarrosModelo(String modelo) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCarrosModelo'");
    }
    
}
