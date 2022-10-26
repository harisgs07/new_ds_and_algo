import java.util.ArrayDeque;
import java.util.Queue;

public class stackImplementationusingQueue {
    ArrayDeque<Integer> firstQueue = new ArrayDeque<>();
    ArrayDeque<Integer> secondQueue = new ArrayDeque<>();

    void push(int data) {
        while (!firstQueue.isEmpty())
            secondQueue.offer(firstQueue.poll());
        firstQueue.offer(data);
        while (!secondQueue.isEmpty()) {
            firstQueue.offer(secondQueue.poll());
        }
    }

    void pop() {
        if (firstQueue.isEmpty()) {
            System.out.println("Empty Stack");
            return;
        }
        System.out.println(firstQueue.poll());
    }

    public static void main(String[] args) {
        stackImplementationusingQueue obj = new stackImplementationusingQueue();
        obj.push(10);
        obj.push(20);
        obj.pop();
        obj.pop();
        obj.pop();

    }

}
