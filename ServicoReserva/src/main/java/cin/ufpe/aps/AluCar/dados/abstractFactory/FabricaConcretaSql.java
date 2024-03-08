
package cin.ufpe.aps.AluCar.dados.abstractFactory;

import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.RepositorioCarrosSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.RepositorioReservasSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios.RepositorioUsuarioSql;


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

    @Override
    public RepositorioUsuarioSql CriaRepoUsuario() {
        RepositorioUsuarioSql usuarioSql = new RepositorioUsuarioSql(databaseDAO);
        return usuarioSql;
    }
}

