import java.util.Scanner;

public class FloorAndCeilBST {

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

    Node rootCeil, rootFloor, prev;
    int curMax = Integer.MAX_VALUE;
    int curMin = Integer.MIN_VALUE;

    void floorOrCeil(Node root, int key) {

        while (root != null) {
            if (root.data > key) {
                if (curMax > root.data)
                    curMax = root.data;
                root = root.left;
            } else if (root.data < key) {
                if (curMin < root.data)
                    curMin = root.data;
                root = root.right;
            }

        }
        System.out.println(curMin + " " + curMax);

    }

    public static void main(String[] args) {
        FloorAndCeilBST obj = new FloorAndCeilBST();
        Node root = obj.createNode();
        obj.floorOrCeil(root, 4);
    }
}
