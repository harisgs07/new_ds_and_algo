public class bubblesort {
    public static void main(String[] args) {
        boolean swap = true;
        int[] arr = { 1, 2, 3 };
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    arr = swap(arr, j + 1, j);
                    swap = false;

                }
            }
            if (swap == true) {
                System.out.println("alredy sorted");
                break;
            }
        }
        for (var i : arr) {
            System.out.print(i + " ");
        }
    }

    static int[] swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        return arr;
    }
}
