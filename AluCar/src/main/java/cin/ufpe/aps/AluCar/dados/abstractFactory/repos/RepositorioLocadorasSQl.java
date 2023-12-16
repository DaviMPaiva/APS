
package cin.ufpe.aps.AluCar.dados.abstractFactory.repos;

import java.sql.Connection;

import cin.ufpe.aps.AluCar.dados.abstractFactory.IRepositorio;
import cin.ufpe.aps.AluCar.models.Locadora;

class RepositorioLocadorasSQl implements IRepositorio{
    
    private Connection sqlConnection;

    // Constructor that takes a SQL database connection
    public RepositorioLocadorasSQl (Connection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    @Override
    public Locadora getLocadora() {
        // Implement your logic to retrieve a Locadora from the SQL database
        return null; // Replace with your actual implementation
    }

    @Override
    public void setLocadora(Locadora locadora) {
        // Implement your logic to store a Locadora in the SQL database
        //this.locadora = locadora; // Replace with your actual implementation
    }
}