package cin.ufpe.aps.AluCar.dados.abstractFactory;

import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.RepositorioCarrosSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.locadoras.RepositorioLocadorasSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.RepositorioReservasSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios.RepositorioUsuarioSql;

public class FabricaConcretaH2 implements FabricaAbstrataRepositorio{

    @Override
    public RepositorioReservasSql CriaRepoReservas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CriaRepoReservas'");
    }

    @Override
    public RepositorioLocadorasSql CriarRepoLocadoras() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CriarRepoLocadoras'");
    }

    @Override
    public RepositorioCarrosSql CriaRepoCarros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CriaRepoCarros'");
    }

    @Override
    public RepositorioUsuarioSql CriaRepoUsuario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CriaRepoUsuario'");
    }
     
}
