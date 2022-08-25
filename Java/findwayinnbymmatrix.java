import java.util.Arrays;
import java.util.Scanner;

public class findwayinnbymmatrix {

    public static void main(String[] args) {
        System.out.println(matrixCreation(3, 1));
    }

    public static int matrixCreation(int row, int col) {

        if (row == 1 || col == 1) {
            return 1;
        }
        return matrixCreation(row - 1, col) + matrixCreation(row, col - 1);
    }
}
