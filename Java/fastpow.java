public class fastpow {
    static void fpow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a;
                b = b - 1;
            } else {
                a = a * a;
                b = b >> 1;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        fpow(5, 3);
    }

}
