public class ithelementinarrayrecursion {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, 6, 4 };
        System.out.println(search(arr, 3, 0));

    }

    static boolean search(int[] arr, int element, int i) {
        // System.out.println(arr[i]);
        if (i == arr.length - 1) {
            return false;

        }
        return arr[i] == element || search(arr, element, i + 1);

    }
}
