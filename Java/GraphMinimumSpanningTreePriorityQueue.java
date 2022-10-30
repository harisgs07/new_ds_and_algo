import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

class Pair implements Comparable<Pair> {
    int vertex;
    int edge;

    public Pair(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
    }

    @Override
    public int compareTo(Pair edgePassed) {
        // TODO Auto-generated method stub
        return this.edge - edgePassed.edge;
    }

}

public class GraphMinimumSpanningTreePriorityQueue {

    static ArrayList<ArrayList<Pair>> adjList;
    static boolean[] visited;

    public GraphMinimumSpanningTreePriorityQueue(int vertices) {

        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<>());
        visited = new boolean[vertices];
    }

    static void addEdge(int start, int end, int vertices, int weight, boolean bidirectional) {
        adjList.get(start).add(new Pair(end, weight));
        if (bidirectional)
            adjList.get(end).add(new Pair(start, weight));
    }

    static PriorityQueue<Pair> minedge = new PriorityQueue<>();
    static int ans = 0;

    static void bfs(int start, int vertices) {

        minedge.add(new Pair(0, 0));
        while (!minedge.isEmpty()) {
            Pair cur = minedge.poll();
            if (visited[cur.vertex])
                continue;
            ans = ans + cur.edge;
            visited[cur.vertex] = true;

            for (Pair i : adjList.get(cur.vertex)) {
                if (!visited[i.vertex]) {
                    minedge.add(i);
                }
            }
        }

        System.out.println("ans is " + ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the vertices:");
        int vertices = sc.nextInt();
        GraphMinimumSpanningTreePriorityQueue obj = new GraphMinimumSpanningTreePriorityQueue(vertices);
        System.out.println("Enter the Minimum Number Of Edges:");
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the Start Element: ");
            int start = sc.nextInt();
            System.out.println("Enter the End Element: ");
            int end = sc.nextInt();
            System.out.println("Enter the Weight: ");
            int weight = sc.nextInt();

            addEdge(start, end, vertices, weight, true);
        }
        bfs(0, vertices);

    }

}
