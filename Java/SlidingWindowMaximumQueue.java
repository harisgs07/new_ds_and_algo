import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximumQueue {
    Deque<Integer> maxElm = new ArrayDeque<>();

    void findMax(int[] arr, int range) {
        for (int i = 0; i < range; i++) {
            if (maxElm.isEmpty())
                maxElm.offer(arr[i]);
            else {
                while (!maxElm.isEmpty()) {
                    if (maxElm.peekLast() < arr[i])
                        maxElm.pollLast();
                    else
                        break;
                }
                maxElm.offerLast(arr[i]);
            }
        }
        System.out.print(maxElm.peekFirst() + " ");
        int firstElm = -1;
        for (int i = range; i < arr.length; i++) {
            firstElm++;
            if (arr[firstElm] == maxElm.peekFirst())
                maxElm.pollFirst();
            while (!maxElm.isEmpty()) {
                if (maxElm.peekLast() < arr[i])
                    maxElm.pollLast();
                else
                    break;
            }
            maxElm.offer(arr[i]);
            System.out.print(maxElm.peekFirst() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5 };
        SlidingWindowMaximumQueue obj = new SlidingWindowMaximumQueue();
        obj.findMax(arr, 3);
    }

}
