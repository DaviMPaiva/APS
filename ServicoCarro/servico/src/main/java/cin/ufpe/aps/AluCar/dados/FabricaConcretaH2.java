package cin.ufpe.aps.AluCar.dados;

import cin.ufpe.aps.AluCar.dados.reservas.RepositorioReservasH2;
import cin.ufpe.aps.AluCar.dados.carros.RepositorioCarrosH2;

public class FabricaConcretaH2 implements FabricaAbstrataRepositorio{

    DatabaseDAOH2 databaseDAOH2 = new DatabaseDAOH2();

    @Override
    public RepositorioReservasH2 CriaRepoReservas() {
        RepositorioReservasH2 reservasH2 = new RepositorioReservasH2(databaseDAOH2);
        return reservasH2; 
    }

    @Override
    public RepositorioCarrosH2 CriaRepoCarros() {
        RepositorioCarrosH2 carrosH2 = new RepositorioCarrosH2(databaseDAOH2);
        return carrosH2; 
    }
     
}
