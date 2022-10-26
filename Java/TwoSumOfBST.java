import java.util.HashMap;
import java.util.Scanner;

public class TwoSumOfBST {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Node createNode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value ");
        int element = sc.nextInt();
        if (element == -1)
            return null;
        Node root = new Node(element);
        System.out.println("Enter value to the left of " + root.data);
        root.left = createNode();
        System.out.println("Enter value to the right of " + root.data);
        root.right = createNode();
        return root;
    }

    HashMap<Integer, Integer> sumBalance = new HashMap<>();
    int count = 0;

    int findPair(Node root, int sum) {
        if (root == null)
            return 0;
        if (sumBalance.containsKey(root.data)) {
            count = count + 1;
            System.out.println(sumBalance.get(root.data) + " " + root.data);
            return 0;
        } else {
            sumBalance.put(sum - root.data, root.data);
        }
        findPair(root.left, sum);
        findPair(root.right, sum);
        return count;
    }

    public static void main(String[] args) {
        TwoSumOfBST obj = new TwoSumOfBST();
        Node root = obj.createNode();
        int val = obj.findPair(root, 80);
        if(val == 0){
            System.out.println("No sum of "+80);
        }
    }
}
