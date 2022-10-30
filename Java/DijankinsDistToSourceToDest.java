import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
    int vertex, edges;

    public Pair(int vertex, int edges) {
        this.edges = edges;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return this.edges - o.edges;
    }
}

public class DijankinsDistToSourceToDest {

    static ArrayList<ArrayList<Pair>> adjList;
    static boolean[] visited;

    public DijankinsDistToSourceToDest(int vertex) {
        adjList = new ArrayList<>();
        visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<>());
    }

    static void addEdges(int start, int end, boolean bidirectional, int vertex, int weight) {
        adjList.get(start).add(new Pair(end, weight));
        if (bidirectional)
            adjList.get(end).add(new Pair(end, weight));
    }

    static PriorityQueue<Pair> priorqueue = new PriorityQueue<>();

    static void bfs(int start, int vertex) {

        int[] ans = new int[vertex];
        Arrays.fill(ans, 1000);
        ans[start] = 0;
        priorqueue.add(new Pair(start, 0));
        while (!priorqueue.isEmpty()) {
            Pair cur = priorqueue.poll();
            if (visited[cur.vertex])
                continue;
            visited[cur.vertex] = true;
            for (Pair i : adjList.get(cur.vertex)) {
                if (ans[i.vertex] > ans[cur.vertex] + i.edges) {
                    ans[i.vertex] = ans[cur.vertex] + i.edges;
                    priorqueue.add(i);
                }
            }
        }

        for (int j = 0; j < vertex; j++) {
            System.out.println(start + " --> " + j + " " + ans[j]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Vertices Graph Have ");
        int vertex = sc.nextInt();
        System.out.println("Enter the Minimum Number of Edges Graph Have ");
        int edges = sc.nextInt();

        DijankinsDistToSourceToDest obj = new DijankinsDistToSourceToDest(vertex);

        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the Start Element: ");
            int start = sc.nextInt();
            System.out.println("Enter the End Element: ");
            int end = sc.nextInt();
            System.out.println("Enter the Weight: ");
            int weight = sc.nextInt();
            addEdges(start, end, true, vertex, weight);
        }
        bfs(0, vertex);
    }

}
