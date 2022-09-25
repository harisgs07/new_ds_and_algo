
import java.lang.*;

public class stocksingle {
    public static void main(String[] args) {
        int [] arr = {2,1,3,5,6};
        stock(arr);
    }
    static void stock(int [] arr){
        int start = 0;
        int end = 0;
        int profit = 0;
        int currentprofit = arr[0];
        int max = arr[0];
        for(int i: arr){
            currentprofit =Math.min(i,currentprofit);
            profit = i-currentprofit;
            max = Math.max(max,profit);

        }
        System.out.println(max);
    }

    // Other way is to use the auxillary  array of max array from end and minus the value from the orginal array!!
}
