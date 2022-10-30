import java.util.Scanner;

public class DisjointUsingCompresion {

    static int[] parent, rank;

    public DisjointUsingCompresion(int vertex) {
        parent = new int[vertex];
        for (int i = 0; i < vertex; i++)
            parent[i] = i;
        rank = new int[vertex];
    }

    static int findRoot(int x) {
        if (parent[x] != x)
            parent[x] = findRoot(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int a_root = findRoot(a);
        int b_root = findRoot(b);

        if (a_root == b_root)
            return;

        if (rank[a_root] < rank[b_root])
            parent[a_root] = b_root;

        else if (rank[a_root] > rank[b_root])
            parent[b_root] = a_root;

        else {
            parent[b_root] = a_root;
            rank[a_root] = rank[a_root] + 1;
        }
    }

    static void checkFriend(int a, int b) {
        int a_root = findRoot(a);
        int b_root = findRoot(b);

        if (a_root == b_root)
            System.out.println("They are friends");
        else
            System.out.println("They are not");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Vertex ");
        int vertex = sc.nextInt();
        DisjointUsingCompresion obj = new DisjointUsingCompresion(vertex);
        union(0, 1);
        union(2, 7);
        union(3, 6);
        checkFriend(0, 2);
        union(0, 7);
        checkFriend(0, 2);
    }

}
