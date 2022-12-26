package collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> extends AbstractList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int size; // 1

    public MyArrayList(int initialCapacity) {
        if (initialCapacity == 0) {
            initialCapacity = DEFAULT_CAPACITY;
        }

        data = (E[]) new Object[initialCapacity];

    }

    public MyArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(int index, E element) { // index = 1 element = 74547
        check(index);
        ensureCapacity();
        for (int i = size() - 1; i >= index; i--) { // data = {1, 74547, 7, 8, 96, 0} size = 5 length = 6 i = 1
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        checkRange(index);
        return data[index];
    }

    @Override
    public E set(int index, E element) {
        E replaced = data[index];
        data[index] = element;
        return replaced;
    }

    @Override
    public int indexOf(Object element) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(element)) {
                index = i;
                break;
            }
        }

        return index;
    }

    @Override
    public int lastIndexOf(Object element) {
        int index = -1;
        for (int i = size() - 1; i >= 0; i--) {
            if (data[i].equals(element)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        E elementToRemove = data[index];

        for (int i = index; i + 1 < size; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return elementToRemove;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        boolean isPresent = false;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    public void trimToSize() {
        if (data.length == size) {
            return;
        }
        data = Arrays.copyOf(data, size);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    private void ensureCapacity() {
        if (size() >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("For index=" + index + " size=" + size());
        }
    }

    private void check(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("For index=" + index + " size=" + size());
        }
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("[");

        for (int i = 0; i < size(); i++) {
            if (i + 1 < size()) {
                content.append(data[i]).append(", ");
            } else {
                content.append(data[i]).append("]");
            }
        }
        return content.toString();
    }

    private class IteratorImpl implements Iterator<E> {

        private int currentIndex; // {4, 8, 9, null, null, null} length = 6, size = 3, currentIndex = 3

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            return data[currentIndex++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(currentIndex - 1);
        }
    }
}