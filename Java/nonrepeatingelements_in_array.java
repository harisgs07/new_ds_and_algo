import java.util.*;
import java.io.*;

public class nonrepeatingelements_in_array {

    public static void findElements() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] elements = { 1, 1, 2, 7,3, 4, 2 };
        for (int i : elements) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
            // System.out.println(i);
        }

        System.out.println(map);
    }

    public static void main(String[] args) {
        findElements();

    }
}
