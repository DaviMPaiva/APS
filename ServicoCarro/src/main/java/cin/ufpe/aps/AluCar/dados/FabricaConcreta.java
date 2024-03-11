package cin.ufpe.aps.AluCar.dados;

import cin.ufpe.aps.AluCar.dados.carros.RepositorioCarros;

public class FabricaConcreta implements FabricaAbstrataRepositorio{

    @Override
    public RepositorioCarros CriaRepoCarros() {
        RepositorioCarros carrosH2 = new RepositorioCarros();
        return carrosH2; 
    }
     
}
