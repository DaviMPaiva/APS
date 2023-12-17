
package cin.ufpe.aps.AluCar.dados.abstractFactory;
import cin.ufpe.aps.AluCar.dados.abstractFactory.*;
import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.RepositorioCarrosSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.locadoras.RepositorioLocadorasSQl;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.RepositorioReservasSQl;
import cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios.RepositorioUsuarioSql;


public class FabricaConcretaSQl implements FabricaAbstrataRepositorio {
    DatabaseDAO databaseDAO = new DatabaseDAO();

    @Override
    public RepositorioReservasSQl CriaRepoReservas() {
        RepositorioReservasSQl rrsql = new RepositorioReservasSQl(databaseDAO);
        return rrsql;
    }

    @Override
    public RepositorioLocadorasSQl CriarRepoLocadoras() {
        RepositorioLocadorasSQl locadorasSql = new RepositorioLocadorasSQl(databaseDAO);
        return locadorasSql;
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

