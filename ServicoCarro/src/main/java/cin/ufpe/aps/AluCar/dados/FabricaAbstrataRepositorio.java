
package cin.ufpe.aps.AluCar.dados;


import cin.ufpe.aps.AluCar.dados.carros.IRepositorioCarros;
import cin.ufpe.aps.AluCar.dados.reservas.IRepositorioReservas;

public interface FabricaAbstrataRepositorio {
    IRepositorioReservas CriaRepoReservas();
    IRepositorioCarros CriaRepoCarros();
}
