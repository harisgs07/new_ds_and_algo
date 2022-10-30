public class LongestPalindromeSubsequence {

    static void minInsAndDel(String s1, String s2, int[][] dp) {
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        System.out.println("Length Palindrome of s1 and s2: "
                + dp[s1.length()][s2.length()]);
    }

    public static void main(String[] args) {
        String s1 = "abcde";

        String s2 = "";
        for (int i = s1.length() - 1; i >= 0; i--)
            s2 = s2 + s1.charAt(i);
        System.out.println(s2);
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        minInsAndDel(s1, s2, dp);

    }

}
