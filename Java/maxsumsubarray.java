
//Brute force coding 

public class maxsumsubarray {
    public static void main(String[] args) {
        int[] arr = { 1, -2, 2 };
        int[] temp = findsubarray(arr);
        for (int i : temp)
            System.out.println(i);
    }

    static int[] findsubarray(int[] arr) {
        int[] index = new int[2];
        int check_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            if (i == arr.length) {
                break;
            }
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum < 0) {
                    break;
                } else if (check_sum < sum) {
                    check_sum = sum;
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        System.out.println(index[1]);
        int start, k;
        int[] temp = new int[index[1]];
        for (start = index[0], k = 0; start <= index[1] && k < arr.length; start++, k++) {
            temp[k] = arr[start];
        }
        return temp;
    }
}

// O(N**2) tym and O(1) space complexity