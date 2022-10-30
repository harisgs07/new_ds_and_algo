
public class knapsackProblem {

    static int knapProblem(int[][] items, int weight, int iposremain) {
        int ValFinal = Integer.MIN_VALUE;
        for (int i = iposremain; i < items.length; i++) {
            int w = items[i][1];
            int val = items[i][0];

            if (weight == 0)
                return 0;
            else if (weight < 0)
                return Integer.MIN_VALUE;

            int subVal = knapProblem(items, weight - w, iposremain + 1);
            if (subVal != Integer.MIN_VALUE && subVal + val > ValFinal)
                ValFinal = subVal + val;
        }
        return ValFinal;
    }

    public static void main(String[] args) {
        int[][] items = { { 20, 1 }, { 30, 3 }, { 10, 4 }, { 50, 6 } };
        int weight = 10;
        System.out.println("Max Value for weight " + weight + " is " + knapProblem(items, weight, 0));
    }
}
