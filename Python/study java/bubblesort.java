
public class bubblesort {
    public static void main(String[] args) {
        boolean s = false;
        int[] arr = { 1, 3, 2, 5, -4, -1 };
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                    s = true;
                }
            }
        }
        if (!s) {
            System.out.println("alredy sorted");
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
