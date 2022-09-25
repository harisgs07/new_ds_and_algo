import java.util.Arrays;

import javax.swing.JPopupMenu.Separator;

public class BacktrackingNqueen {

    public static boolean isSafe(boolean[][] chessboard, int row, int col, int colpos, int rowpos) {
        int i, j;
        for (i = 0; i < row; i++) {
            if (chessboard[i][colpos] == true) {
                return false;
            }
        }
        for (i = rowpos, j = colpos; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == true)
                return false;
        }
        for (i = rowpos, j = colpos; i >= 0 && j < col; i--, j++) {
            if (chessboard[i][j] == true)
                return false;
        }
        return true;
    }

    public static boolean nQueen(boolean[][] chessboard, int row, int col, int currow) {
        if (currow == row) {
            for (boolean[] vv : chessboard) {
                for (boolean v : vv) {
                    System.out.print(v + ",");
                }
                System.out.println('\n');
            }
            return true;
        }
        for (int i = 0; i < col; i++) {
            System.out.println(currow + " " + i);
            System.out.println(isSafe(chessboard, row, col, i, currow));
            if (isSafe(chessboard, row, col, i, currow)) {
                chessboard[currow][i] = true;
                if (nQueen(chessboard, row, col, currow + 1)) {
                    return true;
                }
                chessboard[currow][i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] chessboard = new boolean[4][4];
        for (boolean[] i : chessboard) {
            Arrays.fill(i, false);
        }

        if (nQueen(chessboard, 4, 4, 0)) {
            System.out.println("Printed are the position of queen");
        } else {
            System.out.println("No Possibilities");
        }
    }
}
