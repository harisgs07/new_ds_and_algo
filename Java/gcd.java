import java.util.Scanner;

public class gcd {
    public static void gcdFind(int a, int b) {

        if (b == 0) {
            System.out.println(a);
        } else
            gcdFind(b, a % b);
    }

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        gcdFind(obj.nextInt(), obj.nextInt());

    }

}
