package cin.ufpe.aps.AluCar.dados.abstractFactory.carros;

import java.sql.SQLException;

import cin.ufpe.aps.AluCar.models.Car;

public interface IRepositorioCarros {
    Car getCarro() throws SQLException;
    void setCarro(Car car);
}
