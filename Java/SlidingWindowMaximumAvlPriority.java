import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximumAvlPriority {
    PriorityQueue<Integer> maxofWindow = new PriorityQueue<>(Collections.reverseOrder());

    void slidingMaximum(int[] arr, int range) {
        for (int i = 0; i < range; i++)
            maxofWindow.offer(arr[i]);
        System.out.print(maxofWindow.peek() + " ");
        int firstElemnt = -1;
        for (int i = range; i < arr.length; i++) {
            firstElemnt++;
            maxofWindow.remove(arr[firstElemnt]);
            maxofWindow.offer(arr[i]);
            System.out.print(maxofWindow.peek() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5 };
        SlidingWindowMaximumAvlPriority obj = new SlidingWindowMaximumAvlPriority();
        obj.slidingMaximum(arr, 3);
    }
}
