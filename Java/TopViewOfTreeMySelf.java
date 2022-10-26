import java.util.Scanner;
import java.util.ArrayList;

public class TopViewOfTreeMySelf {

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

    ArrayList<Integer> leftSide = new ArrayList<>();
    ArrayList<Integer> rightSide = new ArrayList<>();

    void topView(Node root) {

        Node rootRightStart = root.right;
        while (root != null) {
            leftSide.add(root.data);
            root = root.left;
        }
        while (rootRightStart != null) {
            rightSide.add(rootRightStart.data);
            rootRightStart = rootRightStart.right;
        }
        for (int i = leftSide.size() - 1; i >= 0; i--)
            System.out.print(leftSide.get(i) + " ");
        for (Integer i : rightSide)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        TopViewOfTreeMySelf obj = new TopViewOfTreeMySelf();
        Node root = obj.createNode();
        obj.topView(root);
    }
}
