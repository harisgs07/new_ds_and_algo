// Iterative solution for Josephus Problem
class Test {

    // Method for finding the winning child.
    private int josephus(int n, int k) {
        int sum = 0;

        // For finding out the removed
        // chairs in each iteration
        for (int i = 2; i <= n; i++) {
            sum = (sum + k) % i;
        }

        return sum + 1;
    }

    // Driver Program to test above method
    public static void main(String[] args) {
        int n = 8;
        int k = 4;
        Test obj = new Test();
        System.out.println(obj.josephus(n, k));
    }
}

// This code is contributed by Kumar Saras
