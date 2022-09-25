import java.util.*;
import java.lang.*;

public class sudoku {
    static boolean ifFeasible(int[][] arr, int row, int col, int num) {
        // row wise search
        for (int fc = 0; fc < arr.length; fc++) {
            if (arr[row][fc] == num) {
                return false;
            }
        }

        // col wise search
        for (int fr = 0; fr < arr.length; fr++) {
            if (arr[fr][col] == num) {
                return false;
            }
        }

        // for each box
        int root = (int) Math.sqrt(arr.length);
        int boxrowstart = row - row % root;
        int boxcolstart = col - col % root;
        for (int fr = boxrowstart; fr < (boxrowstart + root); fr++) {
            for (int fc = boxcolstart; fc < (boxcolstart + root); fc++) {
                if (arr[fr][fc] == num)
                    return false;
            }
        }
        return true;
    }

    static boolean solveSudoku(int[][] arr, int row, int col) {
        boolean value = false;
        if ((row == arr.length - 1) && (col == arr.length - 1)) {
            return true;
        }
        for (int j = row; j < arr.length; j++) {
            for (int k = 0; k < arr.length; k++) {
                if (arr[j][k] == 0) {
                    row = j;
                    col = k;
                    value = true;
                    break;
                }
            }
            if (value)
                break;
        }

        for (int i = 1; i <= arr.length; i++) {
            if (ifFeasible(arr, row, col, i)) {
                arr[row][col] = i;
                if (solveSudoku(arr, row, col)) {
                    return true;
                }
                arr[row][col] = 0;
            }
        }    
    return false;
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 2, 4, 0 },
                        { 1, 0, 0, 3 },
                        { 4, 0, 0, 2 },
                        { 0, 1, 3, 0 } };
        if (solveSudoku(arr, 0, 0)) {
            for (int[] i : arr) {
                for (int a : i) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        } else
            System.out.println("Not Solved");
    }
}
