package cin.ufpe.aps.AluCar.dados.carros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cin.ufpe.aps.AluCar.dados.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.Car;

public class RepositorioCarrosH2 implements IRepositorioCarros {
    private DatabaseDAOH2 databaseDAOH2;

    public RepositorioCarrosH2 (DatabaseDAOH2 databaseDAOH2){
        this.databaseDAOH2 = databaseDAOH2;
    }

    @Override
    public Car getCarro(String placaRecebe) {
        Car car = null;
       
        try (ResultSet result = this.databaseDAOH2.executeQuery("SELECT * FROM car WHERE placa = '"+  placaRecebe +"'")) {
    
            // Check if the result set has a row
            if (result.next()) {
                // Retrieve values from the result set
                String modelo = result.getString("modelo");
                String placa = result.getString("placa");
                Float preco = result.getFloat("preco");
                int ano = result.getInt("ano");
                String combustivel = result.getString("combustivel");
                String transmissao = result.getString("transmissao");
                String linkFotos = result.getString("linkFotos");
                Integer locadora = result.getInt("locadora");
    
                // Create a Car object using the retrieved values
                car = new Car(modelo, placa, preco, ano, combustivel, transmissao, linkFotos, locadora);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return car;
    }

    @Override
    public List<Car> getAllCarro() {
        Car car = null;
        List<Car> listaCarros = new ArrayList<Car>();
    
        
        try (ResultSet result = this.databaseDAOH2.executeQuery("SELECT * FROM car")) {
    
            // Check if the result set has a row
            while (result.next()) {
                // Retrieve values from the result set
                String modelo = result.getString("modelo");
                String placa = result.getString("placa");
                Float preco = result.getFloat("preco");
                int ano = result.getInt("ano");
                String combustivel = result.getString("combustivel");
                String transmissao = result.getString("transmissao");
                String linkFotos = result.getString("linkFotos");
                Integer locadora = result.getInt("locadora");
    
                // Create a Car object using the retrieved values
                car = new Car(modelo, placa, preco, ano, combustivel, transmissao, linkFotos, locadora);
                listaCarros.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return listaCarros;
    }

    @Override
    public List<Car> getCarrosModelo(String modeloPesquisa) {
        Car car = null;
        List<Car> listaCarros = new ArrayList<Car>();
        String sql = "SELECT * FROM car WHERE modelo = '" + modeloPesquisa + "'";
        System.out.println(sql);
    
        
        try (ResultSet result = this.databaseDAOH2.executeQuery(sql)) {
    
            // Check if the result set has a row
            while (result.next()) {
                // Retrieve values from the result set
                String modelo = result.getString("modelo");
                String placa = result.getString("placa");
                Float preco = result.getFloat("preco");
                int ano = result.getInt("ano");
                String combustivel = result.getString("combustivel");
                String transmissao = result.getString("transmissao");
                String linkFotos = result.getString("linkFotos");
                Integer locadora = result.getInt("locadora");
    
                // Create a Car object using the retrieved values
                car = new Car(modelo, placa, preco, ano, combustivel, transmissao, linkFotos, locadora);
                listaCarros.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return listaCarros;
    }

    @Override
    public void setCarro(Car car) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");
    }

}
