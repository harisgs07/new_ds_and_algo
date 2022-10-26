import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class DiameterOfTree {
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

    ArrayDeque<Node> stackDll = new ArrayDeque<>();

    Node head = null;

    /*
     * int height(Node root) {
     * if (root == null)
     * return 0;
     * return Math.max(height(root.left), height(root.right)) + 1;
     * }
     * 
     * int diameterTree(Node root) {
     * if (root == null)
     * return 0;
     * int dleft = diameterTree(root.left);
     * int dright = diameterTree(root.right);
     * int cur = height(root.left) + height(root.right) + 1;
     * return Math.max(cur, Math.max(dleft, dright));
     * }
     */

    // O(n) other is o(n2)
    int ans = 0;

    int diameterTree(Node root) {
        if (root == null)
            return 0;
        int dleft = diameterTree(root.left) + 1;
        int dright = diameterTree(root.right) + 1;

        ans = Math.max(ans, Math.max(dleft,dright));
        
        if(dleft == 0) return dright;
        if(dright == 0) return dleft;

        return ans;
    }

    public static void main(String[] args) {
        DiameterOfTree obj = new DiameterOfTree();
        Node root = obj.createNode();
        System.out.println(obj.diameterTree(root));
    }
}
