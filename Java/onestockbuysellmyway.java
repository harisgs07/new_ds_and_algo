public class onestockbuysellmyway {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 8, 7, 2, 5 };
        findstock(arr);
    }

    static void findstock(int[] arr) {
        int min, max;
        min = arr[0];
        max = 0;
        int[] index = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                index[1] = i;
            }
            if (arr[i] <= min) {
                min = arr[i];
                index[0] = i;
            }
            if (index[1] <= index[0]) {
                max = 0;
            }
        }
        int daystart = index[0] + 1;
        int dayend = index[1] + 1;
        System.out.println("Buy this stock @ " + arr[index[0]] + " Rs Which is " + daystart + " day");
        System.out.println("Sell this stock @ " + arr[index[1]] + " Rs Which is " + dayend + " day");
        System.out.println("Max Profit is " + (arr[index[1]] - arr[index[0]]));
    }
}
