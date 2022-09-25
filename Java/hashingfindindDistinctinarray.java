import java.util.*;

public class hashingfindindDistinctinarray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 3 };
        int[] arrsecond = { 3, 2, 5, 6, 7 };
        HashSet<Integer> setarr = new HashSet<>();
        // finding the distinct
        for (int i : arr)
            setarr.add(i);

        for (int j : setarr)
            System.out.print(j + " ");
        System.out.println();

        // union of 2 array
        // setarr alrdy have arr

        for (int i : arrsecond)
            setarr.add(i);

        System.out.println(setarr);

        // intersection of 2 array
        Set<Integer> setarrsecond = new TreeSet<>();
        System.out.println("Intersection");
        for (int i : arrsecond)
            setarrsecond.add(i);
        setarrsecond.addAll(setarr);
        System.out.println(setarrsecond);
    }
}