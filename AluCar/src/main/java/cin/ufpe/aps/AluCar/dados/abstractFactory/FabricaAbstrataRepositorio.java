
package cin.ufpe.aps.AluCar.dados.abstractFactory;

import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.RepositorioCarrosSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.locadoras.RepositorioLocadorasSQl;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.RepositorioReservasSQl;
import cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios.RepositorioUsuarioSql;

public interface FabricaAbstrataRepositorio {
    RepositorioReservasSQl CriaRepoReservas();
    RepositorioLocadorasSQl CriarRepoLocadoras();
    RepositorioCarrosSql CriaRepoCarros();
    RepositorioUsuarioSql CriaRepoUsuario();
}
