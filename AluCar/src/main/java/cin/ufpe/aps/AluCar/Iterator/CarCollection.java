/*package cin.ufpe.aps.AluCar.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cin.ufpe.aps.AluCar.models.Car;

// Iterable collection: CarCollection
class CarCollection implements Iterable<Car> {
    private List<Car> cars;

    public CarCollection() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public Iterator<Car> iterator() {
        return new CarListIterator(cars);
    }
}

public class CarCollection implements Iterator {

    private ConcreteAggregate aggregate;
    private int currentIndex;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < aggregate.getItems().size();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        return aggregate.getItems().get(currentIndex++);
    }
}*/