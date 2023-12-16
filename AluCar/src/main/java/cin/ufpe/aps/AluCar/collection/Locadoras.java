package cin.ufpe.aps.AluCar.collection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cin.ufpe.aps.AluCar.models.Car;

@Component
public class Locadoras {

    private List<Car> cars;

    public Locadoras() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCarros() {
        return this.cars;
    }

    public void addCarro(Car car) {
        this.cars.add(car);
    }

    public void visualizarLocadoras() {
        System.out.println("Locadora: ");
        for (Car car : this.cars) { 
        System.out.println(car.getPlaca());
        }
    }

    public void modificacoesLocadoras() {
    }

}
