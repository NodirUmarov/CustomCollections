import collection.MyArrayList;
import collection.MyLinkedList;
import collection.MyList;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> linkedList = new MyLinkedList<>();

        linkedList.add("A");
        linkedList.offer("B");

        Deque<String> dequeLinkedList = (Deque<String>) linkedList;
        dequeLinkedList.offerFirst("C");
        dequeLinkedList.offerFirst("D");
        dequeLinkedList.offerFirst("E");

        MyList<String> list = (MyList<String>) dequeLinkedList;
        list.add(2, "F");

    }
}