package cin.ufpe.aps.AluCar.proxy;

import cin.ufpe.aps.AluCar.Iterator.CarList;
import cin.ufpe.aps.AluCar.collection.Carros;
import cin.ufpe.aps.AluCar.models.*;
import cin.ufpe.aps.AluCar.utils.PropertiesReader;

public interface InterfaceReservas {

    // Pesquisa carros disponíveis e retorna um objeto Carro
    CarList pesquisaCarrosDisponiveis(Reserva reserva, Carros cars, PropertiesReader propertiesReader);
}
