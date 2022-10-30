
public class LongestSequenceUtube {

    static String ansString = "";

    static int longSubsequence(String big, int bigC, String small, int smallC, int[][] dp) {
        int ans = Integer.MIN_VALUE;
        if (bigC == 0 || smallC == 0)
            return 0;
        if (dp[bigC][smallC] != -1) {
            return dp[bigC][smallC];
        }
        if (big.charAt(bigC - 1) == small.charAt(smallC - 1)) {
            dp[bigC][smallC] = 1 + longSubsequence(big, bigC - 1, small, smallC - 1, dp);
            return dp[bigC][smallC];
        } else {
            dp[bigC][smallC] = Math.max(longSubsequence(big, bigC - 1, small, smallC, dp),
                    longSubsequence(big, bigC, small, smallC - 1, dp));
            return dp[bigC][smallC];
        }
    }

    public static void main(String[] args) {
        String s1 = "abcab";
        String s2 = "aecb";

        if (s1.length() >= s2.length()) {
            int[][] dp = new int[s2.length() + 1][s1.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length + 1; j++) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = -1;
                }
            }
            System.out.println(longSubsequence(s1, s1.length(), s2, s2.length(), dp));
        } else {
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length + 1; j++) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = -1;
                }
            }
            System.out.println(longSubsequence(s2, s2.length(), s1, s1.length(), dp));
        }
        System.out.println(ansString);

    }
}
