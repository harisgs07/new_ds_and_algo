import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class findsubarraywithgivensum {
    static void subarry(int[] arr, int checksum) {
        int currentsum = 0;
        int ifcheck = 0;
        int count = 0;
        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> arrsum = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currentsum += arr[i];
            arrsum.put(currentsum, i);
            System.out.println(arrsum);
            ifcheck = currentsum - checksum;
            if (ifcheck == 0) {
                count += 1;
                end = i;
                break;
            } else if (arrsum.containsKey(ifcheck)) {
                count += 1;
                end = i;
                start = arrsum.get(ifcheck) + 1;
                break;
            }
        }

        if (count == 0)
            System.out.println("Not found");
        else
            System.out.println("Index start: " + start + " and Index end: " + end);
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, -1, 2 };
        int checksum = 3;
        subarry(arr, checksum);
    }
}
