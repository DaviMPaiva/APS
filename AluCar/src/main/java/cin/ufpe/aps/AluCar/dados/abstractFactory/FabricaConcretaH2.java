package cin.ufpe.aps.AluCar.dados.abstractFactory;

import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.RepositorioCarrosH2;
import cin.ufpe.aps.AluCar.dados.abstractFactory.locadoras.RepositorioLocadorasSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.RepositorioReservasSql;
import cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios.RepositorioUsuarioSql;

public class FabricaConcretaH2 implements FabricaAbstrataRepositorio{

    DatabaseDAOH2 databaseDAOH2 = new DatabaseDAOH2();

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
    public RepositorioCarrosH2 CriaRepoCarros() {
        RepositorioCarrosH2 carrosH2 = new RepositorioCarrosH2(databaseDAOH2);
        return carrosH2; 
    }

    @Override
    public RepositorioUsuarioSql CriaRepoUsuario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CriaRepoUsuario'");
    }
     
}
