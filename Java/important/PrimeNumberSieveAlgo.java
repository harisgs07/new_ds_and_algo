
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class PrimeNumberSieveAlgo {
    static void prime(int num) {
        boolean[] primeindex = new boolean[num];
        Arrays.fill(primeindex, true);
        primeindex[0] = false;
        primeindex[1] = false;
        for (int i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
            for (int j = i * 2; j < num; j = j + i) {
                primeindex[j] = false;
            }
        }

        for (int k = 0; k < num; k++) {
            if (primeindex[k] == true)
                System.out.println(k);
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        prime(obj.nextInt());
    }

}
