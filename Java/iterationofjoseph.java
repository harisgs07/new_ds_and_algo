public class iterationofjoseph {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(josephus(a));
    }

    static int josephus(int N) {
        int p = 2;
        while (p <= N)
            p *= 2;

        return (2 * N) - p + 1;
    }

}
