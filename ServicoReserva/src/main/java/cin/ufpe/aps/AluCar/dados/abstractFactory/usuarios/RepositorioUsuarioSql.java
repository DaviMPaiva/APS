package cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAO;
import cin.ufpe.aps.AluCar.models.Usuario;

public class RepositorioUsuarioSql implements IRepositorioUsuarios{

    private DatabaseDAO databaseDAO;

    public RepositorioUsuarioSql (DatabaseDAO databaseDAO) {
        this.databaseDAO = databaseDAO;
    }

    @Override
    public Usuario getUsuario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetUsuario'");
    }

    @Override
    public void SetUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetUsuario'");
    }
    
}
