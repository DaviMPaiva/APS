package cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios;


import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Usuario;

public class RepositorioUsuarioH2 implements IRepositorioUsuarios{

    private DatabaseDAOH2 databaseDAOH2;

    public RepositorioUsuarioH2 (DatabaseDAOH2 databaseDAOH2) {
        this.databaseDAOH2 = databaseDAOH2;
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
