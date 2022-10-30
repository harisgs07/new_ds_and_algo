import java.util.Arrays;

public class CoinRecursionChalToParticularSum {

    static int coins(int n, int[] a, int[] dp) {

        int ans = Integer.MAX_VALUE;

        if (n == 0)
            return 0;

        for (int i = 0; i < a.length; i++) {

            if (n - a[i] >= 0) {
                int subans = 0;
                if (dp[n - a[i]] != -1)
                    subans = dp[n - a[i]];
                else
                    subans = coins(n - a[i], a, dp);

                if (subans != Integer.MAX_VALUE && subans + 1 < ans)
                    ans = subans + 1;
            }
        }
        return dp[n] = ans;

    }

    public static void main(String[] args) {
        int[] a = { 7, 5, 1 };
        int n = 18;
        int[] dp = new int[19];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println("count is " + coins(n, a, dp));
    }

}
