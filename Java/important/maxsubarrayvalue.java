//Dynamic programing
public class maxsubarrayvalue {
    public static void main(String[] args) {
        int[] arr = { 5, -4 };
        // , 0, 3, 4, -1 };
        sumsubarray(arr);
    }

    static void sumsubarray(int[] arr) {
        int sum = 0;
        int ressum = arr[0];
        for (int i : arr) {
            sum = sum + i;
            if (ressum < sum) {
                ressum = sum;
            }
            if (ressum < i) {
                ressum = i;
                sum = i;
            }
        }
        System.out.println(ressum);
    }
}
// O(N) and O(1)