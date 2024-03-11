package cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios;

import cin.ufpe.aps.AluCar.models.Usuario;

public interface IRepositorioUsuarios {
    Usuario getUsuario();
    void SetUsuario(Usuario usuario);
}
