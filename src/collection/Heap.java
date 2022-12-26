package collection;

import java.util.Collections;

public class Heap<E extends Comparable<E>> {

    private MyArrayList<E> tree;

    public Heap() {
        this.tree = new MyArrayList();
    }

    public void add(E element) {
        tree.add(element);

        int currentIndex = tree.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (tree.get(currentIndex).compareTo(tree.get(parentIndex)) > 0) {
                Collections.swap(tree, currentIndex, parentIndex);
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    public E remove() {
        if (tree.isEmpty()) {
            return null;
        }

        E removedObject = tree.get(0);
        E lastElement = tree.get(tree.size() - 1);
        tree.set(0, lastElement);
        tree.remove(tree.size() - 1);

        int currentIndex = 0;
        while (currentIndex < tree.size()) {
            int leftChild = currentIndex * 2 + 1;
            int rightChild = currentIndex * 2 + 2;

            if (leftChild >= tree.size()) {
                break;
            }

            int actualChild = leftChild;

            if (rightChild < tree.size() && tree.get(rightChild).compareTo(tree.get(leftChild)) > 0) {
                actualChild = rightChild;
            }

            if (tree.get(actualChild).compareTo(tree.get(currentIndex)) > 0) {
                Collections.swap(tree, actualChild, currentIndex);
                currentIndex = actualChild;
            } else {
                break;
            }
        }

        return removedObject;
    }
}