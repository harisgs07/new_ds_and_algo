import java.io.*;

public class rainnwaterharvarypreprocesng {
    public int rainwater(int[] arr) {
        int volume = 0;
        int[] auxleft = new int[arr.length];
        int[] auxright = new int[arr.length];
        auxleft[0] = arr[0];
        auxright[arr.length - 1] = arr[arr.length - 1];

        // max from left
        for (int i = 1; i < arr.length; i++) {
            auxleft[i] = Math.max(arr[i], auxleft[i - 1]);
        }

        // max from right
        for (int i = arr.length - 1; i > 0; i--) {
            auxright[i - 1] = Math.max(arr[i - 1], auxright[i]);

        }
        for (int j = 0; j < arr.length; j++) {
            volume += ((Math.min(auxleft[j], auxright[j])) - arr[j]);
        }
        return volume;

    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4, 0, 1, 2, 3 };
        rainnwaterharvarypreprocesng obj = new rainnwaterharvarypreprocesng();
        System.out.println(obj.rainwater(arr));
    }
}
