import java.util.HashMap;

public class countdistinctineverykwindow {
    static void window(int[] arr, int k) {
        int removeelementat = -1;
        HashMap<Integer, Integer> elem = new HashMap<>();
        for (int i = 0; i < k; i++)
            elem.put(arr[i], elem.getOrDefault(arr[i], 0) + 1);

        System.out.println(elem.size());
        // Slidingwindow in array
        for (int i = k; i < arr.length; i++) {
            removeelementat += 1;
            if (elem.get(arr[removeelementat]) == 1)
                elem.remove(arr[removeelementat]);
            else
                elem.put(arr[removeelementat], elem.get(arr[removeelementat]) - 1);
            elem.put(arr[i], elem.getOrDefault(arr[i], 0) + 1);

            // System.out.println(elem);
            System.out.println(elem.size());
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 3, 1, 1, 3 };
        int k = 4;
        window(arr, k);
    }
}
