package cin.ufpe.aps.AluCar.dados.abstractFactory.carros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.Car;

public class RepositorioCarrosH2 implements IRepositorioCarros {
    private DatabaseDAOH2 databaseDAO;

    public RepositorioCarrosH2 (DatabaseDAOH2 databaseDAO){
        this.databaseDAO = databaseDAO;
    }

    @Override
    public Car getCarro() {
        Car car = null;
    
        
        try (ResultSet result = this.databaseDAO.executeQuery("SELECT * FROM \"CAR\" WHERE placa = 'DEF5678'")) {
    
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
    public void setCarro(Car car) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCarro'");
    }

    @Override
    public List<Car> getCarrosModelo(String modelo) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCarrosModelo'");
    }
}
