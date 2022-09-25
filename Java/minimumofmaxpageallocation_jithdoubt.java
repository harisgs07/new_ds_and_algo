public class minimumofmaxpageallocation_jithdoubt {

    boolean addValueofloop(int[] sgs) {
        sgs[0] = 5;
        return true;
    }

    void allocation(int[] arr, int low, int high) {
        int res = 0;
        int min = 0;
        int max = 0;
        for (int i : arr) {
            max += i;
        }
        if (low > high) {
            System.out.println(res);
        }
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (addValueofloop(arr)) {
                System.err.println("over");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        minimumofmaxpageallocation_jithdoubt obj = new minimumofmaxpageallocation_jithdoubt();
        obj.allocation(arr, 0, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
