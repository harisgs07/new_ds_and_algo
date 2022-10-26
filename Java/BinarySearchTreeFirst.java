import java.util.Scanner;

public class BinarySearchTreeFirst {
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

    int binarySearch(Node root, int element) {
        if (root == null)
            return 0;
        if (root.data == element)
            return 1;
        if (root.data > element)
            return binarySearch(root.left, element);
        else
            return binarySearch(root.right, element);
    }

    public static void main(String[] args) {
        BinarySearchTreeFirst obj = new BinarySearchTreeFirst();
        Node root = obj.createNode();
        if (obj.binarySearch(root, 30) == 1)
            System.out.println("Found Element");
        else
            System.out.println("No Element Found");
    }

}
