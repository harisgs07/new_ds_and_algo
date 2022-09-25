public class quicksort {

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void quickFunction(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickFunction(arr, low, pi - 1);
            quickFunction(arr, pi + 1, high);
        }
    }

    static void printarr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 4, 9, 1, 22, 6 };
        quickFunction(arr, 0, arr.length - 1);
        printarr(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}
