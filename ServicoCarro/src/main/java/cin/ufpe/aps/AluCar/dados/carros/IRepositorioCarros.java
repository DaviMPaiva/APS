package cin.ufpe.aps.AluCar.dados.carros;

import java.sql.SQLException;
import java.util.List;

import cin.ufpe.aps.AluCar.models.*;

public interface IRepositorioCarros {
    List<Reserva> getCache() throws SQLException;
    List<Car> getAllCars() throws SQLException;
    Car getCarro(String placa) throws SQLException;
    List<Car> getCarrosModelo(String modelo) throws SQLException;
    void setCarro(Car car);
    List<Car> getAllCarro();
}
