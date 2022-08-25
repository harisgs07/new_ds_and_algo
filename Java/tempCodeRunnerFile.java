import java.lang.Math;
import java.io.*;
import java.util.*;

public class powersetfromstring {
    public static void main(String[] args) {
        powerset();
    }

    static void powerset() {
        ArrayList<String> res = new ArrayList<>();

        String a = "harikrishnan is a";
        for (int i = 0; i <= (1 << a.length()); i++) {
            String b = " ";
            for (int j = 0; j < a.length(); j++) {
                if (((i & (1 << j)) >> j) == 1) {
                    b += a.charAt(j);
                }
            }
            res.add(b);
        }
        System.out.println(res);
    }
}
// time n2^n
// space O(1)