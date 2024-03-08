package cin.ufpe.aps.AluCar.dados.abstractFactory.carros;

import java.sql.SQLException;
import java.util.List;

import cin.ufpe.aps.AluCar.models.Car;

public interface IRepositorioCarros {
    Car getCarro(String placa) throws SQLException;
    List<Car> getCarrosModelo(String modelo) throws SQLException;
    void setCarro(Car car);
    List<Car> getAllCarro();
}
