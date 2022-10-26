import java.util.Scanner;

public class rightViewOfTheTree {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Node createNode() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number");
        int data = sc.nextInt();
        if (data == -1)
            return null;
        Node root = new Node(data);
        System.out.println("Enter the number left to" + root.data);
        root.left = createNode();
        System.out.println("Enter the number right to" + root.data);
        root.right = createNode();
        return root;

    }

    int maxLevel = 0;

    void rightView(Node root, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }

    public static void main(String[] args) {
        rightViewOfTheTree obj = new rightViewOfTheTree();
        Node root = obj.createNode();
        obj.rightView(root, 1);
    }

}
