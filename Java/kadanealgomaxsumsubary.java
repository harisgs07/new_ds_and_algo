public class kadanealgomaxsumsubary {
    public static void main(String[] args) {
        int[] arr = { -2, 1, 2 };
        int[] tempindex = kadaneAlgo(arr);
        for (int i = tempindex[0]; i <= tempindex[1]; i++) {
            System.out.println(arr[i]);
        }
    }

    static int[] kadaneAlgo(int[] arr) {
        int sum = 0;
        int ressum = 0;
        int[] index = new int[2];
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                if (arr[i] > 0) {
                    sum = arr[i];
                    index[0] = i + 1;
                } else {
                    sum = 0;
                    index[0] = i + 1;
                }
            } else {
                if (ressum < sum) {
                    ressum = sum;
                    index[1] = i;
                }
            }
        }
        System.out.println("Sum is " + ressum);
        return index;
    }
}

// O(N) tym and O(1) space