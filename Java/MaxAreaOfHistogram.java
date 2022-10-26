import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class MaxAreaOfHistogram {

    Deque<Integer> previousSmaller = new ArrayDeque<>();
    Deque<Integer> afterSmaller = new ArrayDeque<>();

    void maxAreaFind(int[] histogram) {

        int[] prev = new int[histogram.length];
        int[] after = new int[histogram.length];
        int area = 0;
        int tempArea = 0;

        for (int i = 0; i < histogram.length; i++) {
            while (!previousSmaller.isEmpty() && histogram[previousSmaller.peek()] >= histogram[i])
                previousSmaller.pop();
            if (previousSmaller.isEmpty())
                prev[i] = -1;
            else
                prev[i] = previousSmaller.peek();
            previousSmaller.push(i);
        }

        for (int i = histogram.length - 1; i >= 0; i--) {
            while (!afterSmaller.isEmpty() && histogram[afterSmaller.peek()] >= histogram[i])
                afterSmaller.pop();
            if (afterSmaller.isEmpty())
                after[i] = histogram.length;
            else
                after[i] = afterSmaller.peek();
            afterSmaller.push(i);
        }

        for (int i = 0; i < histogram.length; i++) {
            tempArea = (after[i] - prev[i] - 1) * histogram[i];
            if (area < tempArea) {
                area = tempArea;
            }
        }
        System.out.println(area);

    }

    public static void main(String[] args) {
        int[] histogram = { 4, 3, 2, 1, 7, 6, 0, 8 };
        MaxAreaOfHistogram obj = new MaxAreaOfHistogram();
        obj.maxAreaFind(histogram);

    }

}
