public class heapsort {
    static int[] heapify(int[] arr, int len, int i) {
        // System.out.println(len);
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;
        int largest = i;

        // left side is greater or not
        if ((left < len) && (arr[left] > arr[largest]))
            largest = left;
        if ((right < len) && (arr[right] > arr[largest]))
            largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, len, largest);
        }
        return arr;
    }

    static void sortThem(int[] arr) {
        int len = arr.length - 1;
        for (int i = len; i > 0; i--) {
            System.out.println("hi");
            arr[i] = arr[i] ^ arr[0];
            arr[0] = arr[i] ^ arr[0];
            arr[i] = arr[i] ^ arr[0];
            arr = heapify(arr, i, 0);
        }
        for (int each : arr) {
            System.out.print(each + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 14,10,15}; 
        sortThem(arr);
    }
}
