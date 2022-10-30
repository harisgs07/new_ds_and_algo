import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
    int src, dest, weight;

    public Pair(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return this.weight - o.weight;
    }
}

public class kruskalMinSpanningTree {

    static int[] parent, rank;
    static boolean[] visited;
    static ArrayList<Pair> pq = new ArrayList<>();
    static int ans = 0;

    public kruskalMinSpanningTree(int vertex) {
        parent = new int[vertex];
        for (int i = 0; i < vertex; i++)
            parent[i] = i;
        rank = new int[vertex];
        visited = new boolean[vertex];
    }

    static int find(int source) {
        if (parent[source] != source)
            parent[source] = find(parent[source]);
        return parent[source];
    }

    static void union(int a, int b) {
        int a_root = find(a);
        int b_root = find(b);

        if (a_root == b_root)
            return;

        if (rank[a_root] > rank[b_root])
            parent[b_root] = a_root;
        else if (rank[a_root] < rank[b_root])
            parent[a_root] = b_root;
        else {
            parent[b_root] = a_root;
            rank[a_root] = rank[a_root] + 1;
        }
    }

    static void SpaningtreeKrus(int[][] edge, int vertex) {
        for (int i = 0; i < edge.length; i++) {
            int src = edge[i][0];
            int dest = edge[i][1];
            int wei = edge[i][2];
            pq.add(new Pair(src, dest, wei));
        }

        int count = 1;
        Collections.sort(pq);

        for (int i = 0; count < vertex; i++) {
            int src_parent = find(pq.get(i).src);
            int dest_parent = find(pq.get(i).dest);
            if (src_parent != dest_parent) {
                union(src_parent, dest_parent);
                count++;
                ans = ans + pq.get(i).weight;
            }
        }
        System.out.println("ans is : " + ans);
    }

    public static void main(String[] args) {
        int vertex = 5;
        int[][] edge = { { 0, 1, 1 }, { 2, 1, 2 }, { 2, 3, 7 }, { 2, 4, 4 }, { 3, 4, 8 }, { 1, 4, 5 },
                { 1, 0, 1 }, { 1, 2, 2 }, { 3, 2, 7 }, { 4, 2, 4 }, { 4, 3, 8 }, { 4, 1, 5 } };
        kruskalMinSpanningTree obj = new kruskalMinSpanningTree(vertex);
        SpaningtreeKrus(edge, vertex);
    }

}
