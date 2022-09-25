/**
 * insertionsort
 */
public class insertionsort {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, -4 };
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        for (int i : arr) {
            System.out.println(i);
        }

    }
}