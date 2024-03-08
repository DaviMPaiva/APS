package cin.ufpe.aps.AluCar.Iterator;

import java.util.List;

import cin.ufpe.aps.AluCar.models.Car;
import cin.ufpe.aps.AluCar.models.Usuario;

import java.util.ArrayList;

public class CarList {
    private List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public CarIterator createIterator(Usuario usuario) {
        //will change the iterator based on the type of user
        CarIterator carIterator;
        if(usuario.getSexo() == 'm'){
            carIterator = new CarListIteratorMan(cars);
        }else{
            carIterator = new CarListIteratorWoman(cars);
        }
        return carIterator;
    }

}

