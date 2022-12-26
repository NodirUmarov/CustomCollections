package collection;

public class MyStack<E> implements Stack<E> {
    private MyLinkedList<E> source;

    public MyStack() {
        source = new MyLinkedList<>();
    }

    @Override
    public void push(E element) {
        source.offerFirst(element);
    }

    @Override
    public E pop() {
        return source.pollFirst();
    }

    @Override
    public E peek() {
        return source.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return source.isEmpty();
    }
}
