package cin.ufpe.aps.AluCar.collection;

import cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios.IRepositorioUsuarios;

public class Usuarios {

    private IRepositorioUsuarios repoUsuarios;
    public Usuarios(IRepositorioUsuarios repoUsuarios){
        this.repoUsuarios = repoUsuarios;
    }
}
