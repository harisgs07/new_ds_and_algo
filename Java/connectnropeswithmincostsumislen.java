import java.util.Collections;
import java.util.PriorityQueue;

public class connectnropeswithmincostsumislen {
    static void minCost(int[] arr, int numberOfropeconnected, int s) {
        // int [] subarr = new int[s];
        PriorityQueue<Integer> ropelength = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < numberOfropeconnected; i++)
            ropelength.offer(arr[i]);
        while (ropelength.size() > (s - 1)) {
            for (int i = 0; i < s; i++) {
                sum += ropelength.poll();
            }
            ropelength.offer(sum);
            sum = 0;
        }
        int count = 0;
        for (Integer j : ropelength) {
            if (count == (arr.length) % (s - (s - 1))) {
                System.out.println(j);
                break;
            }
            count += 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 4, 3, 7 };
        // to find out the minmum cost of joining all the rope taking s at a time
        int s = 4;
        int numberOfropeconnected = arr.length;
        if (s > arr.length || s == 1) {
            System.out.println("No Value Found");
        } else
            minCost(arr, numberOfropeconnected, s);
    }
}