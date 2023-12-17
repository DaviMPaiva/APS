/*package cin.ufpe.aps.AluCar.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConcreteIterator implements Iterator {

    private ConcreteAggregate aggregate;
    private int currentItem;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public boolean hasNext() {
        return currentItem < aggregate.getItems().size();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return aggregate.getItems().get(currentItem++);
    }
}*/