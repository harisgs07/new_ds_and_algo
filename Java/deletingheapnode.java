import java.util.Arrays;

public class deletingheapnode {
    static void deleteNode(int[] arr1, int element) {
        int temp = arr1[arr1.length - 1];
        int[] arr = Arrays.copyOfRange(arr1, 0, arr1.length - 1);
        arr[0] = temp;
        int len = arr.length - 1;
        int i = 0;
        // int temp=0;
        while (i < len) {
            int leftside = i * 2 + 1;
            int rightside = i * 2 + 2;
            if (leftside > len || rightside > len)
                break;
            int largest = arr[leftside] > arr[rightside] ? leftside : rightside;
            if (arr[i] < arr[largest]) {
                arr[i] = arr[i] ^ arr[largest];
                arr[largest] = arr[i] ^ arr[largest];
                arr[i] = arr[i] ^ arr[largest];
            }
            i = largest;
            System.out.println(i);
        }
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 50, 40, 30, 20, 10, 15, 14 };
        int element = 9;
        deleteNode(arr, element);
    }

}
