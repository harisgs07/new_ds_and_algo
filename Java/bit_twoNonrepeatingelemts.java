public class bit_twoNonrepeatingelemts {
    public static void main(String[] args) {
        int[] a = { 1, 1, 9, 7, 4, 4, 5, 5 };
        int res = 0;
        int temp = 0;
        for (int i : a) {
            res = res ^ i;
        }
        temp = (res & -res);
        // System.out.println(temp);
        int a1 = 0;
        int a2 = 0;
        for (int j : a) {
            if ((j & temp) > 0) {
                a1 = a1 ^ j;
            } else {
                a2 = a2 ^ j;
            }
        }

        System.out.println(a1);
        System.out.println(a2);

    }

}
