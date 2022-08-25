public class palindromeNumber {
    static String palindrome(int num) {
        int org = num;
        int val = 0;
        while (num != 0) {
            val = (val * 10) + (num % 10);
            num = num / 10;
        }
        if (val == org) {
            return "yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        System.out.println(palindrome(202));
    }

}
