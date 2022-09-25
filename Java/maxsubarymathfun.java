import java.io.*;

public class maxsubarymathfun {
    public static void main(String[] args) {
        int[] arr = { 5, -4 };
        // , 0, 3, 4, -1 };
        sumsubarray(arr);
    }

    static void sumsubarray(int[] arr) {
        int sum = 0;
        int ressum = arr[0];
        for (int i : arr) {
            sum = Math.max(i, sum + i);
            ressum = Math.max(ressum, sum);
        }
        System.out.println(ressum);
    }
}
