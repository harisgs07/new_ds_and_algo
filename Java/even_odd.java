import java.util.Scanner;

public class even_odd {
    public static boolean check(int num) {
        // even has last bit always 0 so using and operator we performe 1
        // it must give0 or 1 as output if num is even then perfomring 1 gives 
        // 0 as output
        if ((num & 1) == 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int num = obj.nextInt();
        if (check(num))
            System.out.print("ODD " + num);
        else
            System.out.print("Even " + num);

    }

}
