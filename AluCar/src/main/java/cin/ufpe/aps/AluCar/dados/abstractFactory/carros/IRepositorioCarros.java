package cin.ufpe.aps.AluCar.dados.abstractFactory.carros;

import cin.ufpe.aps.AluCar.models.Car;

public interface IRepositorioCarros {
    Car getCarro();
    void setCarro(Car car);
}
