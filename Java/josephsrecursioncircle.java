public class josephsrecursioncircle {
    public static void main(String[] args) {
        System.out.println(josph(14, 2));
    }

    static int josph(int nodes, int interval) {
        if (nodes == 1) {
            return 0;
        }
        return (josph(nodes - 1, interval) + interval) % nodes - 1;
    }

}
