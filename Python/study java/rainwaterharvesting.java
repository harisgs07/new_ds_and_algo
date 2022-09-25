import java.lang.Math;

public class rainwaterharvesting {
    static void harvesting(int[] arr) {
        int sum = 0;
        int[] maxleft = new int[arr.length];
        int[] maxright = new int[arr.length];
        maxleft[0] = arr[0];
        maxright[arr.length - 1] = arr[arr.length - 1];

        // auxilary arrays with max from left and right
        for (int i = 1; i < arr.length; i++) {
            maxleft[i] = Math.max(arr[i], maxleft[i - 1]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            maxright[i] = Math.max(arr[i], maxright[i + 1]);
        }
        for (int i = 0; i < arr.length; i++) {
            sum = sum + (Math.min(maxleft[i], maxright[i]) - arr[i]);
        }
        System.out.println(sum);

    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4, 0, 1, 2, 3 };
        harvesting(arr);
    }

}
