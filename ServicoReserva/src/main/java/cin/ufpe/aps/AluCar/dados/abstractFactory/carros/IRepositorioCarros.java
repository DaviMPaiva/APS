package cin.ufpe.aps.AluCar.dados.abstractFactory.carros;

import java.util.List;

import cin.ufpe.aps.AluCar.models.Car;

public interface IRepositorioCarros {
    List<Car> getAllCarro();
}
