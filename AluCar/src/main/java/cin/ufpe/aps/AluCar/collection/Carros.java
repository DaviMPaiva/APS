package cin.ufpe.aps.AluCar.collection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.IRepositorioCarros;
import cin.ufpe.aps.AluCar.models.Car;

public class Carros {

    private IRepositorioCarros repoCarros;
    private Car carro;
    private List<Car> carros;
    public Carros(IRepositorioCarros repoCarros){
        this.repoCarros = repoCarros;
    }

    public Car getCarroPorPlaca(String placa){
        try {
            this.carro = this.repoCarros.getCarro(placa);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carro;
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
}
