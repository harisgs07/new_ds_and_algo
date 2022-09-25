import java.sql.Timestamp;
import java.time.Instant;
import java.util.PriorityQueue;
import java.util.TimerTask;

public class thMaxelementinanarrayusingpriorityqueue {
    static void maxElement(int[] arr, int k) {
        PriorityQueue<Integer> findkmax = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            findkmax.offer(arr[i]);
        for (int i = k; i < arr.length; i++) {
            if (findkmax.peek() < arr[i]) {
                findkmax.poll();
                findkmax.offer(arr[i]);
            }
        }
        System.out.println(findkmax.peek());
    }

    public static void main(String[] args) {
        int[] arr = { 20, 10, 60, 50, 30, 5, 2, 90 };
        int k = 2;
        maxElement(arr, k);
    }
}
