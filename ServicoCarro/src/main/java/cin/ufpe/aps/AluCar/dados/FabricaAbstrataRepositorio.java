
package cin.ufpe.aps.AluCar.dados;


import cin.ufpe.aps.AluCar.dados.carros.IRepositorioCarros;

public interface FabricaAbstrataRepositorio {
    IRepositorioCarros CriaRepoCarros();
}
