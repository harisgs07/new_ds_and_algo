
public class RepeatingLongestSubSeq {

    static void repeatingLongSubSeq(String s1, String s2, int[][] dp) {
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(" Lenght of repeating Subsequence is " + dp[s1.length()][s2.length()]);
    }

    public static void main(String[] args) {

        String s1 = "abcabdabc";
        String s2 = s1;
        int[][] dp = new int[s1.length() + 1][s1.length() + 1];
        repeatingLongSubSeq(s1, s2, dp);

    }
}
