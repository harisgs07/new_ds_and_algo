import java.util.Scanner;

public class LeastCommonAncestoralNode {
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

    Node lowCommonAncestor(Node root, int leftValue, int rightValue) {
        if (root == null)
            return null;
        if (root.data == leftValue || root.data == rightValue)
            return root;
        Node left = lowCommonAncestor(root.left, leftValue, rightValue);
        Node right = lowCommonAncestor(root.right, leftValue, rightValue);
        if (left == null)
            return right;
        if (right == null)
            return left;
        System.out.println(left.data);
        return root;
    }

    public static void main(String[] args) {
        LeastCommonAncestoralNode obj = new LeastCommonAncestoralNode();
        Node root = obj.createNode();
        System.out.println("Enter left and write");
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        Node ans = obj.lowCommonAncestor(root, left, right);
        System.out.println(ans.data);

    }
}
