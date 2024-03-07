package cin.ufpe.aps.AluCar.dados;

import cin.ufpe.aps.AluCar.dados.reservas.RepositorioReservasSql;
import cin.ufpe.aps.AluCar.dados.carros.RepositorioCarrosSql;

public class FabricaConcretaSql implements FabricaAbstrataRepositorio {

    DatabaseDAO databaseDAO = new DatabaseDAO();

    @Override
    public RepositorioReservasSql CriaRepoReservas() {
        RepositorioReservasSql rrsql = new RepositorioReservasSql(databaseDAO);
        return rrsql;
    }

    @Override
    public RepositorioCarrosSql CriaRepoCarros() {
        RepositorioCarrosSql carrosSql = new RepositorioCarrosSql(databaseDAO);
        return carrosSql; 
    }
}

