import java.util.Arrays;

public class nquee {
    static boolean isSafe(boolean [][] arr,int row,int col){
        int i,j;
        for(i=row,j=col; i>=0 && j>=0;i--, j--){
            if(arr[i][j] == true){
                return false;
            }
        }

        for(i=row,j=col; i>=0 && j< arr.length;i--, j++){
            if(arr[i][j] == true){
                return false;
            }
        }

        for(i = 0;i<arr.length;i++){
            if(arr[i][col] == true){
                return false;
            }
        }
        return true;
    }
    static boolean queenPlacement(boolean [][] arr,int row){
        int column=arr.length;
        
        if(row == arr.length){
            // Print statement
            for (boolean [] i : arr) {
                for (boolean j : i) {
                    System.out.print(j + " ");   
                }
                System.out.println();
            }
            return true;
        }
        for(int i = 0;i < column; i++){
            if(isSafe(arr,row,i)){
                arr[row][i] = true;
                
                if(queenPlacement(arr,row+1)){
                    return true;
                }
                arr[row][i] = false;
            }
            
        }return false;
    }
    public static void main(String[] args) {
        boolean [][]  arr = new boolean[5][5];
        for (boolean [] i : arr) {
            Arrays.fill(i,false);
        }
        queenPlacement(arr,0);   
    }   
}
