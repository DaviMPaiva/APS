package cin.ufpe.aps.AluCar.Iterator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import cin.ufpe.aps.AluCar.models.Car;

public class CarListIteratorWoman implements CarIterator {
    private List<Car> cars;
    private int position;

    public CarListIteratorWoman(List<Car> cars) {
        this.cars = cars;
        this.position = 0;
        this.cars = this.reOrder(cars);
    }

    private List<Car> reOrder(List<Car> cars){

        Collections.sort(cars, Comparator.comparing(Car::getModelo, (s1, s2) -> {
            // Custom comparator to handle substring "Jeep"
            if (s1.contains("Jeep") && !s2.contains("Jeep")) {
                return -1;
            } else if (!s1.contains("Jeep") && s2.contains("Jeep")) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        }));

        return cars;
    }

    @Override
    public boolean hasNext() {
        return position < cars.size();
    }

    @Override
    public Car next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the list");
        }
        Car car = cars.get(position);
        position++;
        return car;
    }
}