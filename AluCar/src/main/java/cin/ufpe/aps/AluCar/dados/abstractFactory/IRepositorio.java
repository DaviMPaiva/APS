package cin.ufpe.aps.AluCar.dados.abstractFactory;

import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Locadora;
import cin.ufpe.aps.AluCar.models.Reserva;
import cin.ufpe.aps.AluCar.models.Usuario;

public interface IRepositorio {
    Locadora getLocadora();
    void setLocadora(Locadora locadora);
}
