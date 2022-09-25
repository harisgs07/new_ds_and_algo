import java.util.Collections;
import java.util.PriorityQueue;

//k th Minimum elemnt using the priority queee
public class thelementinanarrayusingpriorityqueue {
    static void minElement(int[] arr, int k) {
        PriorityQueue<Integer> findmin = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            findmin.offer(arr[i]);
        }
        for (int j = k; j < arr.length; j++) {
            if (findmin.peek() > arr[j]) {
                findmin.poll();
                findmin.offer(arr[j]);
            }
        }
        System.out.println(findmin.peek());
    }

    public static void main(String[] args) {
        int[] arr = { 20, 10, 60, 50, 30, 5, 2, 90 };
        int k = 5;
        minElement(arr, k);
    }
}
