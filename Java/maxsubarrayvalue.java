//Dynamic programing
public class maxsubarrayvalue {
    public static void main(String[] args) {
        int[] arr = { -4, -4, -1 };
        sumsubarray(arr);
    }

    static void sumsubarray(int[] arr) {
        int sum = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        int ressum = arr[0];

        for (int i : arr) {
            count = count + 1;
            sum = sum + i;
            if (ressum <= sum) {
                ressum = sum;
                end = count - 1;
            }
            if (ressum < i) {
                System.out.println("f");
                ressum = i;
                sum = i;
                start = count - 1;
            }
        }
        System.out.println(ressum);
        if (start > end) {
            System.out.println(start + " " + start);
        } else
            System.out.println(start + " " + end);
    }
}
// O(N) and O(1)