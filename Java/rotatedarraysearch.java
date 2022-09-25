// here one side will be sorted position
// here we are checiking
public class rotatedarraysearch {
    static int sortf(int[] arr, int low, int high, int element) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (element == arr[mid]) {
            return 1;
        }
        if (arr[low] <= arr[mid]) {
            if (element >= arr[low] && element <= arr[mid])
                return sortf(arr, low, mid - 1, element);
            return sortf(arr, mid + 1, high, element);
        }
        if (element <= arr[high] && element >= arr[mid])
            return sortf(arr, mid + 1, high, element);
        return sortf(arr, low, mid - 1, element);

    }

    public static void main(String[] args) {
        int[] arr = { 4, 0, 1, 2, 3 };
        int element = 0;
        int value = sortf(arr, 0, arr.length - 1, element);
        if (value != -1) {
            System.out.println("Found");
        } else {
            System.out.println("Nope");
        }
    }

}
