package cin.ufpe.aps.AluCar.collection;

import java.util.List;
import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.IRepositorioCarros;
import cin.ufpe.aps.AluCar.models.Car;

public class Carros {

    private IRepositorioCarros repoCarros;
    private List<Car> carros;
    public Carros(IRepositorioCarros repoCarros){
        this.repoCarros = repoCarros;
    }

    public List<Car> getCarros() {
        this.carros = this.repoCarros.getAllCarro();
        
        return carros;
    }
}
