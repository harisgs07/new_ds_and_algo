public class coinstackmyself {
    static void coin(int [] arr,int low,int high){
        
        if (low == high){
            if(arr[low]==0){
                low = low + 1;
                coin(arr,low,high);
             }
        }

    }

    public static void main(String[] args) {
        int[] arr = {};
        coin(arr, 0, arr.length);
    }

}
