import java.util.HashMap;

public class maxsubarraywitequalzerosandones {
    static void findMaxSubArray(int[] arr) {

        int[] temp = arr;
        int currentsum = 0;
        int start = 0;
        int end = 0;
        int tempstart = 0;
        int tempend = 0;
        int diff = 0;
        HashMap<Integer, Integer> subarray = new HashMap<>();
        // replacing 0 with -1 such that sum of elements in sub array is zeros: so equal
        // zero and ones
        for (int i = 0; i < temp.length; i++)
            temp[i] = temp[i] == 0 ? -1 : 1;
        for (int i = 0; i < temp.length; i++) {
            currentsum += temp[i];

            if (subarray.containsKey(currentsum - 0)) {
                tempstart = subarray.get(currentsum - 0) + 1;
                tempend = i;
                if (diff < (tempend - tempstart)) {
                    start = tempstart;
                    end = tempend;
                    diff = end - start;
                }
            }
            subarray.putIfAbsent(currentsum, i);
            System.out.println(subarray);
        }
        if (currentsum == 0) {
            start = 0;
            end = temp.length - 1;
            System.out.println(start + " is starting index and " + end + " End index");
        } else
            System.out.println(start + " is starting index and " + end + " End index");
    }

    public static void main(String[] args ) {
        int[] arr = { 1, 1, 0, 1, 1, 0, 1};
        findMaxSubArray(arr);
    }
}
