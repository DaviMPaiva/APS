
package cin.ufpe.aps.AluCar.dados.abstractFactory;

import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.RepositorioCarrosSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.locadoras.RepositorioLocadorasSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.RepositorioReservasSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios.RepositorioUsuarioSql;

public interface FabricaAbstrataRepositorio {
    RepositorioReservasSql CriaRepoReservas();
    RepositorioLocadorasSql CriarRepoLocadoras();
    RepositorioCarrosSql CriaRepoCarros();
    RepositorioUsuarioSql CriaRepoUsuario();
}
