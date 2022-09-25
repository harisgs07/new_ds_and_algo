import java.util.Scanner;

public class Maxheapfromarray {
    int[] resizeArray(int[] arr, int len) {
        int[] temp = new int[len + 1];
        int count = 0;
        for (int i : arr) {
            temp[count] = i;
            count += 1;
        }
        arr = temp;
        return arr;
    }

    void insertElement(int[] arr, int newelement, int len) {
        if (arr[len - 1] != 0) {
            arr = resizeArray(arr, len);
        }
        len = arr.length;
        arr[len - 1] = newelement;
        int placedindex = len - 1;
        while (placedindex > 0) {
            int checkparent = (placedindex / 2);
            if (arr[placedindex] > arr[checkparent]) {
                int tempinsert = arr[checkparent];
                arr[checkparent] = arr[placedindex];
                arr[placedindex] = tempinsert;
                placedindex = checkparent;
            } else {
                break;
            }
        }
        printMaxHeap(arr);
    }

    void heapify(int[] arr, int len, int i) {

        int largest = i;
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;

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
    }

    void buildMaxHeap(int[] arr, int len) {
        int startindex = (len / 2) - 1;
        // int startindex = len - 1;
        System.out.println(startindex);
        for (int j = startindex; j >= 0; j--) {
            heapify(arr, len, j);
        }
    }

    void printMaxHeap(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Maxheapfromarray obj = new Maxheapfromarray();
        int[] arr = { 50, 20, 40, 5, 10, 30 };
        obj.buildMaxHeap(arr, arr.length);
        obj.printMaxHeap(arr);
        System.out.println();
        System.out.println("Insert New element to the MaxHeap");
        Scanner sc = new Scanner(System.in);
        int newelement = sc.nextInt();
        obj.insertElement(arr, newelement, arr.length);
        // obj.printMaxHeap(arr);
    }

}
