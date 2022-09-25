
// Java program to connect n
// ropes with minimum cost
import java.util.*;

class mincostrope {
    static int minCost(int arr[], int n) {
        // Create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Adding items to the pQueue
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        // Initialize result
        int res = 0;

        // While size of priority queue
        // is more than 1
        while (pq.size() > 1) {
            // Extract shortest two ropes from pq
            int first = pq.poll();
            int second = pq.poll();

            // Connect the ropes: update result
            // and insert the new rope to pq
            // res += first + second;
            pq.add(first + second);
        }

        return pq.peek();
    }

    // Driver program to test above function
    public static void main(String args[]) {
        int len[] = { 2, 5, 3, 4, 3 };
        int size = len.length;
        System.out.println("Total cost for connecting"
                + " ropes is "
                + minCost(len, size));
    }
}
// This code is contributed by yash_pec
