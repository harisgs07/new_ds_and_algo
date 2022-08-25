
public class apowbrecursion {

    static int recursive(int a, int b) {

        if (b == 1) {
            return a;
        }

        return a * recursive(a, b - 1);

    }

    public static void main(String[] args) {
        System.out.println(recursive(2, 4));
    }
}
