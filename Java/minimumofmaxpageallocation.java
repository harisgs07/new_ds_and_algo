public class minimumofmaxpageallocation {

    boolean addValueofloop(int[] arr, int mid, int maxstd) {
        int student = 1;
        int sum = 0;
        for (int i : arr) {
            if ((sum + i) > mid) {
                student++;
                sum = i;
            } else {
                sum += i;
            }
        }
        return student <= maxstd;
    }

    void allocation(int[] arr, int low, int high, int maxstd) {
        int res = 0;
        int max = 0;
        for (int i : arr) {
            max += i;
        }
        high = max;
        low = arr[arr.length - 1];
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (addValueofloop(arr, mid, maxstd)) {
                res = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 20 };
        int maxstd = 1;
        minimumofmaxpageallocation obj = new minimumofmaxpageallocation();
        obj.allocation(arr, 0, arr.length, maxstd);
    }

}
