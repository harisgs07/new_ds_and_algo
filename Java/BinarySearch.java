import java.util.*;

public class BinarySearch {
    boolean midComparison(int[] arr, int start, int end, int element) {

        while (start <= end) {
            int index = (start + end) >> 1;
            if (element == arr[index]) {
                return true;
            } else if (element < arr[index]) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return false;

        /*
         * // doubt on this since the return or exit statement having doubt
         * if (start <= end) {
         * return false;
         * }
         * int index = (start + end) >> 1;
         * if (element == arr[index]) {
         * return true;
         * } else if (element < arr[index]) {
         * midComparison(arr, start, index - 1, element);
         * } else {
         * midComparison(arr, index + 1, end, element);
         * }
         * return false;
         */
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        Scanner sc = new Scanner(System.in);
        int searchelement = sc.nextInt();
        int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14 };
        if (obj.midComparison(arr, 0, arr.length - 1, searchelement)) {

            System.out.println("found");
        } else {
            System.out.println("Not found");
        }
    }
}
