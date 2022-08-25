import java.util.*;

public class swap_number_bitwise {

    interface myInterface {
        void getSwap(int a, int b);
    }

    static void getNumbers() {
        Scanner obj = new Scanner(System.in);
        int num1 = obj.nextInt();
        int num2 = obj.nextInt();
        myInterface r = new myInterface() {
            public void getSwap(int a, int b) {
                a = (a ^ b);
                b = (a ^ b);
                a = (a ^ b);
                System.out.println(a);
                System.out.println(b);

            };

        };
        r.getSwap(num1, num2);

        // return (finalResult);
    }

    public static void main(String[] args) {
        swap_number_bitwise objMain = new swap_number_bitwise();
        objMain.getNumbers();
        // for (int i = 0; i < b.length; i++) {
        // System.out.println(b[i]);
        // }
    }

}
