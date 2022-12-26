import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(232);
        numbers.add(43);
        numbers.add(56);
        numbers.add(75);

        for (Integer i : numbers) {
            System.out.println(i);
        }

        int size = numbers.size();
        for (int i = 0; i < size; i++) { // i = 2 size = 2
            System.out.println(numbers.poll());
        }
    }
}