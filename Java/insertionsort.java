public class insertionsort {

    public static void main(String[] args) {
        int[] arr = { 8, 2, -4, 3, 9, 1 };
        sortArray(arr);
    }

    static void sortArray(int[] arr) {
        int temp, tempsec, secondarrytemp;
        for (int i = 0; i < (arr.length - 1); i++) {
            temp = arr[i];
            tempsec = arr[i + 1];
            if (tempsec < temp) {
                arr[i] = arr[i] ^ arr[i + 1];
                arr[i + 1] = arr[i] ^ arr[i + 1];
                arr[i] = arr[i] ^ arr[i + 1];
                if (i == 0) {
                    continue;
                } else {
                    secondarrytemp = arr[i];
                    for (int j = i - 1; j >= 0; j--) {
                        if (arr[j] > arr[j + 1]) {
                            arr[j] = arr[j] ^ arr[j + 1];
                            arr[j + 1] = arr[j] ^ arr[j + 1];
                            arr[j] = arr[j] ^ arr[j + 1];
                        } else {
                            break;
                        }

                    }
                }
            }

        }
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }
}
