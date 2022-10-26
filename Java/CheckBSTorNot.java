import java.util.Scanner;

public class CheckBSTorNot {

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

    boolean checkUsingWrapperClass(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data > min || root.data < max)
            return true;
        return (checkUsingWrapperClass(root.left, min, root.data)
                && checkUsingWrapperClass(root.right, root.data, max));

    }

    public static void main(String[] args) {
        CheckBSTorNot obj = new CheckBSTorNot();
        Node root = obj.createNode();
        boolean ans = obj.checkUsingWrapperClass(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (ans)
            System.out.println("Yes Its BST ");
        else
            System.out.println("Not a BST");
    }
}
