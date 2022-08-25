public class recursionpalindromestring {
    public static void main(String[] args) {
        String h = "racecar";
        System.out.println(palindromeString(h, 0, h.length() - 1));
    }

    static boolean palindromeString(String checkelement, int i, int j) {
        if (i > j) {
            return true;
        }
        return checkelement.charAt(i) == checkelement.charAt(j) && palindromeString(checkelement, i + 1, j - 1);
    }

}
