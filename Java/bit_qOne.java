public class bit_qOne {
    public static void main(String[] args) {
        int[] a = { 2, 2, 1, 3, 4, 3, 4 };
        // find the single non repeating elements where all other elements are repeated
        // twice
        int res = 0;
        for (int i : a) {
            res = res ^ i;
        }
        System.out.println(res);

    }

}
