import java.io.*;

public class buyingmultiplestockformaxprofit {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 7, 3, 6, 1, 2, 4 };
        buystock(arr);
    }

    static void buystock(int[] a) {
        int profit = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                profit += a[i] - a[i - 1];
            }
        }
        System.out.println(profit);
    }
}
