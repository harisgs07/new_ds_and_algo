import java.util.ArrayDeque;
import java.util.Deque;;

public class NextGreaterElement {
    Deque<Integer> nxtgreater = new ArrayDeque<>();

    void findNextGreater(int[] arr) {
        int[] temparr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!nxtgreater.isEmpty() && nxtgreater.peek() <= arr[i])
                nxtgreater.pop();
            if (nxtgreater.isEmpty())
                temparr[i] = -1;
            else
                temparr[i] = nxtgreater.peek();
            nxtgreater.push(arr[i]);
        }

        for (int i : temparr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();
        int[] arr = { 4, 10, 5, 8, 20, 15, 3, 12 };
        obj.findNextGreater(arr);

    }

}
