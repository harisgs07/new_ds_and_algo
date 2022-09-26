import java.util.ArrayDeque;
import java.util.Deque;

public class NextSmallerElements {

    Deque<Integer> nxtsmaller = new ArrayDeque<>();

    void lookForSmaller(int[] arr) {
        int[] temparr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!nxtsmaller.isEmpty() && nxtsmaller.peek() >= arr[i])
                nxtsmaller.pop();
            if (nxtsmaller.isEmpty())
                temparr[i] = -1;
            else
                temparr[i] = nxtsmaller.peek();
            nxtsmaller.push(arr[i]);
        }

        for (int i : temparr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 10, 5, 8, 20, 15, 3, 12 };
        NextSmallerElements obj = new NextSmallerElements();
        obj.lookForSmaller(arr);
    }

}
