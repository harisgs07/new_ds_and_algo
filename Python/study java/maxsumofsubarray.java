
// import java.lang.*;

public class maxsumofsubarray {
    public static void main(String[] args) {
        int[] arr = { -4, 4, -1 };
        int start = 0;
        int end = 0;
        int count = -1;
        int resultsum = arr[0];
        int eachsum = 0;
        for (int i : arr) {
            eachsum += i;
            count += 1;
            if (resultsum <= eachsum) {
                resultsum = eachsum;
                end = count;
            }
            // works when everthing is negative
            if (resultsum < i) {
                resultsum = eachsum = i;
                start = count;
            }
        }
        System.out.println(resultsum);
        if (start > end) {
            System.out.println(start + " " + start);
        } else
            System.out.println(start + " " + end);

        // //Using math function !!
        // int resultsum = arr[0];
        // int eachsum = arr[0];
        // for (int i : arr) {
        // eachsum = Math.max(i, eachsum + i);
        // resultsum = Math.max(eachsum, resultsum);
        // }
        // System.out.println(resultsum);
    }
}
