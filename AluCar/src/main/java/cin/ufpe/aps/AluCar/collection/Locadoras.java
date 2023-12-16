package cin.ufpe.aps.AluCar.collection;

import java.util.ArrayList;
import java.util.List;

import cin.ufpe.aps.AluCar.dtos.CarDTO;

public class Locadoras {

    private List<CarDTO> cars;

    public Locadoras() {
        this.cars = new ArrayList<>();
    }

    public List<CarDTO> getCarros() {
        return cars;
    }

    public void addCarro(CarDTO car) {
        this.cars.add(car);
    }

    public void visualizarLocadoras() {
        System.out.println("Locadora: ");
        for (CarDTO car : cars) { 
        System.out.println(car.placa());
        }
    }

    public void modificacoesLocadoras() {
        // TODO: Implement logic for modifying locadora details
    }

}
