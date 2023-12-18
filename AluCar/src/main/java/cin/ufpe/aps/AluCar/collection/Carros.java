package cin.ufpe.aps.AluCar.collection;

import java.sql.SQLException;
import java.util.List;

import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.IRepositorioCarros;
import cin.ufpe.aps.AluCar.models.Car;

public class Carros {

    private IRepositorioCarros repoCarros;
    private Car carro;
    private List<Car> carros;
    public Carros(IRepositorioCarros repoCarros){
        this.repoCarros = repoCarros;
    }

    public Car PesquisaCarrosDisponiveis(){
        try {
            this.carro = this.repoCarros.getCarro();
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
}
