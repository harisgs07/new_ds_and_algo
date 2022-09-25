public class BinarySearch {
    static boolean searchElement(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (element == arr[mid]) {
                return true;
            } else if (element < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6, 7 };
        int element = 51;
        if (searchElement(arr, element)) {
            System.err.println("found");
        } else {
            System.out.println("Not found");
        }
    }
}
