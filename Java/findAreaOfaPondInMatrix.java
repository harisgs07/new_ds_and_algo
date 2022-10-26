import java.util.ArrayList;
import java.util.Arrays;

public class findAreaOfaPondInMatrix {

    static boolean[][] visited;

    public findAreaOfaPondInMatrix(int row, int col) {
        visited = new boolean[row][col];
        // Arrays.fill(visited, false);
    }

    static int rightDfs(int[][] plot, int count, int i, int j) {
        if (j < plot[0].length) {
            System.out.println("right" + count);
            if (!visited[i][j] && plot[i][j] == 0) {
                visited[i][j] = true;
                return count;
            } else if (!visited[i][j] && plot[i][j] == 1) {
                count = count + 1;
                rightDfs(plot, count, i, j + 1);
            }
        }
        return count;
    }

    static int leftDfs(int[][] plot, int count, int i, int j) {

        if (j > -1) {
            System.out.println("left" + count);
            if (!visited[i][j] && plot[i][j] == 0) {
                visited[i][j] = true;
                return count;
            } else if (!visited[i][j] && plot[i][j] == 1) {
                count = count + 1;
                leftDfs(plot, count, i, j - 1);
            }
        }
        return count;
    }

    static int upDfs(int[][] plot, int count, int i, int j) {
        if (i > -1) {
            System.out.println("up" + count);
            if (!visited[i][j] && plot[i][j] == 0) {
                visited[i][j] = true;
                return count;
            } else if (!visited[i][j] && plot[i][j] == 1) {
                count = count + 1;
                upDfs(plot, count, i - 1, j);
            }
        }
        return count;
    }

    static int downDfs(int[][] plot, int count, int i, int j) {
        if (i < plot.length) {
            System.out.println("down" + count);
            if (!visited[i][j] && plot[i][j] == 0) {
                visited[i][j] = true;
                return count;
            } else if (!visited[i][j] && plot[i][j] == 1) {
                count = count + 1;
                downDfs(plot, count, i + 1, j);
            }
        }
        return count;
    }

    static void navigate(int[][] plot, ArrayList<Integer> size, int count) {

        for (int i = 0; i < plot.length; i++) {
            for (int j = 0; j < plot[0].length; j++) {
                if (!visited[i][j] && plot[i][j] == 0) {
                    visited[i][j] = true;
                    continue;
                } else if (!visited[i][j] && plot[i][j] == 1) {
                    visited[i][j] = true;
                    count = count + 1;
                    count = rightDfs(plot, count, i, j + 1);
                    count = leftDfs(plot, count, i, j - 1);
                    count = upDfs(plot, count, i - 1, j);
                    count = downDfs(plot, count, i + 1, j);
                    size.add(count);
                    count = 0;
                }

            }
        }

        int max = Integer.MIN_VALUE;
        for (int k : size)
            max = Math.max(max, k);
        System.out.println("Max Area of Pond is " + max);

    }

    static void findPond(int[][] plot) {

        ArrayList<Integer> size = new ArrayList<>();
        int count = 0;
        System.out.println("Size of the Poll is ");
        navigate(plot, size, count);

    }

    public static void main(String[] args) {
        int plot[][] = { { 1, 0, 0, 1, 1 }, { 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 } };
        findAreaOfaPondInMatrix obj = new findAreaOfaPondInMatrix(plot.length, plot[0].length);
        findPond(plot);

    }

}
