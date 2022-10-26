import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaFromMatrix {

    Deque<Integer> prevSmall = new ArrayDeque<>();
    Deque<Integer> nextSmall = new ArrayDeque<>();

    void findMaxArea(int[][] arr) {
        int[] prev = new int[arr[0].length];
        int[] next = new int[arr[0].length];
        int[] temp = new int[arr[0].length];
        int area = 0;

        // each row from matrix
        for (int[] i : arr) {
            // row added one by one
            for (int j = 0; j < i.length; j++) {
                if (i[j] == 0)
                    temp[j] = 0;
                else
                    temp[j] = temp[j] + i[j];
            }

            // previous small element fro row
            for (int j = 0; j < temp.length; j++) {
                while (!prevSmall.isEmpty() && temp[prevSmall.peek()] >= temp[j])
                    prevSmall.pop();
                if (prevSmall.isEmpty())
                    prev[j] = -1;
                else
                    prev[j] = prevSmall.peek();
                prevSmall.push(j);
            }

            // Next small element fromm row insted of -1 use last index + 1
            for (int j = temp.length - 1; j >= 0; j--) {
                while (!nextSmall.isEmpty() && temp[nextSmall.peek()] >= temp[j])
                    nextSmall.pop();
                if (nextSmall.isEmpty())
                    next[j] = temp.length;
                else
                    next[j] = nextSmall.peek();
                nextSmall.push(j);
            }

            // Max Area
            for (int j = 0; j < temp.length; j++) {
                int curArea = (next[j] - prev[j] - 1) * temp[j];
                if (curArea > area)
                    area = curArea;
            }
        }

        System.out.println(area);
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1, 0 } };
        MaxAreaFromMatrix obj = new MaxAreaFromMatrix();
        obj.findMaxArea(arr);
    }
}
