
public class knapsackProblemTwoDMatrix {

    static void knapSack(int[] w, int[] v, int weight) {

        int[][] matrix = new int[w.length + 1][weight + 1];

        // Initialize
        for (int i = 0; i < w.length + 1; i++) {
            for (int j = 0; j < weight + 1; j++) {
                if (i == 0 || j == 0)
                    matrix[i][j] = 0;
            }
        }

        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < weight + 1; j++) {
                if (j >= w[i - 1] && w[i - 1] > j - w[i - 1]) {
                    if (matrix[i - 1][j] > (v[i - 1] + matrix[i][j - w[i - 1]]))
                        matrix[i][j] = matrix[i - 1][j];
                    else
                        matrix[i][j] = v[i - 1] + matrix[i][j - w[i - 1]];
                    // or matrix[i][j] = Math.Max(matrix[i - 1][j], v[i - 1] + matrix[i][j - w[i -
                    // 1]])
                } else if (w[i - 1] <= j - w[i - 1])
                    matrix[i][j] = matrix[i][j - 1];
                else
                    matrix[i][j] = matrix[i - 1][j];
            }
        }

        for (int[] k : matrix) {
            for (int l : k) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
        System.out.println("Total Value for " + weight + " is " + matrix[w.length][weight]);

    }

    public static void main(String[] args) {
        int[] w = { 1, 3, 4, 6 };
        int[] v = { 20, 30, 10, 50 };
        int weight = 10;
        knapSack(w, v, weight);
    }

}
