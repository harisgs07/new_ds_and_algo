import java.util.ArrayDeque;
import java.util.Scanner;
import java.lang.Math;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class leftViewOfTheTree {

    static Node createNode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data");
        int elm = sc.nextInt();
        if (elm == -1)
            return null;
        Node root = new Node(elm);
        System.out.println("Left number enter " + root.data);
        root.left = createNode();
        System.out.println("Right number enter " + root.data);
        root.right = createNode();
        return root;

    }

    static int maxlevel = 0;

    static void leftView(Node root, int level) {
        if (root == null)
            return;
        if (maxlevel < level) {
            System.out.print(root.data + " ");
            maxlevel = level;
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    public static void main(String[] args) {
        leftViewOfTheTree obj = new leftViewOfTheTree();
        Node root = obj.createNode();
        obj.leftView(root, 1);
    }

}
