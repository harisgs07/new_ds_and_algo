import java.io.*;

public class usingmathstockmaxprofit {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 8, 7, 1, 5 };
        findstock(arr);
    }

    static void findstock(int[] arr) {
        int min, max, profit;
        min = arr[0];
        max = 0;
        profit = 0;
        for (int i : arr) {
            min = Math.min(min, i);
            profit = i - min;
            max = Math.max(max, profit);
        }
        System.out.println("Max Profis is " + max);
    }

}
