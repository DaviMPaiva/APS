package cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios;


import cin.ufpe.aps.AluCar.dados.abstractFactory.DatabaseDAOH2;
import cin.ufpe.aps.AluCar.models.Cartao;
import cin.ufpe.aps.AluCar.models.Usuario;

public class RepositorioUsuarioH2 implements IRepositorioUsuarios{

    private DatabaseDAOH2 databaseDAO;

    public RepositorioUsuarioH2 (DatabaseDAOH2 databaseDAOH2) {
        this.databaseDAO = databaseDAOH2;
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
