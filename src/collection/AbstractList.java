package collection;

import java.util.Collection;
import java.util.List;

public abstract class AbstractList<E> implements List<E> {

    @Override
    public boolean add(E element) {
        int prevSize = size();
        add(size(), element);
        return prevSize != size();
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf((E) o);

        E removed = null;
        if (index != -1) {
            removed = remove(index);
        }
        return removed != null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int prevSize = size();
        for (E element : c) {
            add(size(), element);
        }
        return size() == c.size() + prevSize;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int prevSize = size();
        for (Object o : c) {
            this.remove(o);
        }
        return prevSize != size();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int prevSize = size();
        for (Object o : c) {
            if (!this.contains(o)) {
                this.remove(o);
            }
        }
        return prevSize != size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
