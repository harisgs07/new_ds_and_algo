
public class LongestSequenceMyTry {

    static void longSubsequence(String big, String small) {
        // String ans = "";
        // int k = 0;
        // for (int i = 0; i < small.length(); i++) {
        // for (int j = k; j < big.length(); j++) {
        // if (big.charAt(j) == small.charAt(i)) {
        // k = j;
        // ans = ans + small.charAt(i);
        // break;

        // }
        // }
        // }
        int[][] dp = new int[small.length() + 1][big.length() + 1];
        for (int i = 1; i <= small.length(); i++) {
            for (int j = 1; j <= big.length(); j++) {
                if (big.charAt(j - 1) == small.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println("ans is " + dp[small.length()][big.length()]);
        // System.out.println("ans is " + ans);
    }

    public static void main(String[] args) {
        String s1 = "abcab";
        String s2 = "abcab";
        if (s1.length() >= s2.length())
            longSubsequence(s1, s2);
        else
            longSubsequence(s2, s1);

    }
}
