package cin.ufpe.aps.AluCar.collection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.dados.carros.IRepositorioCarros;
import cin.ufpe.aps.AluCar.models.*;

public class Carros {

    private IRepositorioCarros repoCarros;
    private List<Car> carros;
    private List<Reserva> cache;
    public Carros(IRepositorioCarros repoCarros){
        this.repoCarros = repoCarros;
    }

    public List<Car> PesquisaCarrosModelo(String modelo){
        try {
            this.carros = this.repoCarros.getCarrosModelo(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carros;
    }

    public CarList pesquisaCarrosDisponiveis(Set<String> carroSet){
        List<Car> listaCarros = repoCarros.getAllCarro();

        List<Car> newListCarros = new ArrayList<>();

        for (Car car : listaCarros) {
            if (!carroSet.contains(car.getPlaca())) {
                newListCarros.add(car);
            }
        }

        CarList carList = new CarList(newListCarros);

        return carList;
    }

    public List<Reserva> getCache(){
        try {
            this.cache = this.repoCarros.getCache();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cache;
    }
}
