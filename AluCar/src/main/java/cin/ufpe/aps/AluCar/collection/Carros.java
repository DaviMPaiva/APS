package cin.ufpe.aps.AluCar.collection;

import java.sql.SQLException;

import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.IRepositorioCarros;
import cin.ufpe.aps.AluCar.models.Car;

public class Carros {

    private IRepositorioCarros repoCarros;
    private Car carro;
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
}
