package cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios;

import java.util.ArrayList;

import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAO;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Usuario;

public class RepositorioUsuarioSql implements IRepositorioUsuarios{

    private DatabaseDAO databaseDAO;

    public RepositorioUsuarioSql (DatabaseDAO databaseDAO) {
        this.databaseDAO = databaseDAO;
    }

    @Override
    public Usuario getUsuario() {
        // Mockup 1
        Cartao cartao1 = new Cartao("1234-5678-9012-3456", "John Doe", "01/25", "123");
        Usuario usuario1 = new Usuario("John Doe", "password123", "john.doe@example.com", cartao1);

        return usuario1;
    }

    @Override
    public void SetUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetUsuario'");
    }
    
}
