public class insertionsortsimple {
    public static void main(String[] args) {
        int[] arr = { 8, 2, 1, 1, 3, 9, 1 };
        sortArray(arr);
    }

    static void sortArray(int[] arr) {
        int temp, j;
        for (int i = 0; i < (arr.length); i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }
}
