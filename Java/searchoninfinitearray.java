import java.util.Arrays;
import java.lang.*;

public class searchoninfinitearray {
    static boolean infiniteSearch(int[] arr, int low, int high, int element) {
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (element == arr[mid]) {
                return true;
            } else if (element < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14 };
        int element = 12;
        int low = 0;
        int high = 1;
        int count = 0;
        while ((arr[high] < element) && count == 0) {
            low = high;
            high *= 2;
            if (high >= arr.length) {
                high = arr.length - 1;
                count += 1;
            }
        }
        int[] arrtemp = new int[high - low];
        arrtemp = Arrays.copyOfRange(arr, low, high + 1);
        if (infiniteSearch(arrtemp, 0, arrtemp.length - 1, element)) {

            System.out.println("found");
        } else {
            System.out.println("Not found");
        }
    }
}
