package cin.ufpe.aps.AluCar.dados.abstractFactory.locadoras;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.Locadora;

public class RepositorioLocadorasH2 implements IRepositorioLocadoras{
    
    private DatabaseDAOH2 databaseDAOH2;

    public RepositorioLocadorasH2 (DatabaseDAOH2 databaseDAOH2) {
        this.databaseDAOH2 = databaseDAOH2;
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
