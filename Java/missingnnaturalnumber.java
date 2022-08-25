public class missingnnaturalnumber {
    public static void main(String[] args) {
        // int n = 10;
        int[] arr = { 1, 2, 4, 5, 6 };
        int res = 0;
        int sum = 0;
        int smallest = arr[0];
        for (int i : arr) {
            res = ((res ^ i) + ((res & i) << 1));
            if (i < smallest) {
                smallest = i;
            }
        }
        // ap
        sum = ((arr.length + 1 >> 1) * ((smallest << 1) + (arr.length + 1 - 1)));
        System.out.println(sum - res);
    }

}