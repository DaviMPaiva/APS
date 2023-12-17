
package cin.ufpe.aps.AluCar.dados.abstractFactory.locadoras;


import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAO;
import cin.ufpe.aps.AluCar.models.Locadora;

public class RepositorioLocadorasSql implements IRepositorioLocadoras{
    
    private DatabaseDAO databaseDAO;

    public RepositorioLocadorasSql (DatabaseDAO databaseDAO) {
        this.databaseDAO = databaseDAO;
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