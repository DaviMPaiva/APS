public class ConcreteAggregate implements Aggregate {

    private List<Car> cars;

    public ConcreteAggregate(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    public List<Car> getItems() {
        return cars;
    }
}