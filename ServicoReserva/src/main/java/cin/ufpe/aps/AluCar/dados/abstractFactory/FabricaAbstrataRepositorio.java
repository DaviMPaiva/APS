
package cin.ufpe.aps.AluCar.dados.abstractFactory;


import cin.ufpe.aps.AluCar.dados.abstractFactory.carros.IRepositorioCarros;
import cin.ufpe.aps.AluCar.dados.abstractFactory.reservas.IRepositorioReservas;
import cin.ufpe.aps.AluCar.dados.abstractFactory.usuarios.IRepositorioUsuarios;

public interface FabricaAbstrataRepositorio {
    IRepositorioReservas CriaRepoReservas();
    IRepositorioCarros CriaRepoCarros();
    IRepositorioUsuarios CriaRepoUsuario();
}
