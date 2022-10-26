import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTopologicallSort {

    static int innerdegree[];
    static ArrayList<ArrayList<Integer>> adjList;
    static ArrayDeque<Integer> que = new ArrayDeque<>();

    public GraphTopologicallSort(int vertex) {
        adjList = new ArrayList<>();
        innerdegree = new int[vertex];
        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<>());
    }

    static void addEdge(int start, int end, boolean bidirectional) {
        adjList.get(start).add(end);
        if (bidirectional)
            adjList.get(end).add(start);
    }

    static void bfsStart(int start, int vertex) {
        boolean[] visited = new boolean[vertex];
        bfs(visited, start, vertex);
        for (int i = 0; i < vertex; i++) {
            if (!visited[i])
                bfs(visited, i, vertex);
        }

        for (int i = 0; i < innerdegree.length; i++) {
            System.out.print(i + " --> " + innerdegree[i] + " ");
        }
    }

    static void bfs(boolean[] visited, int start, int vertex) {
        visited[start] = true;
        innerdegree[start] = 0;
        que.add(start);
        while (!que.isEmpty()) {
            int cur = que.remove();
            for (int neighbour : adjList.get(cur)) {
                if (!visited[neighbour]) {
                    que.add(neighbour);
                    visited[neighbour] = true;
                }
                innerdegree[neighbour] = innerdegree[neighbour] + 1;
            }
        }
    }

    static void startTopologicalSort() {

        System.out.println();
        int i = 0;
        while (i < innerdegree.length) {
            if (innerdegree[i] == 0) {
                innerdegree[i] = -1;
                for (int j : adjList.get(i))
                    innerdegree[j] = innerdegree[j] - 1;
                System.out.print(i + " ");
                i = 0;
            } else
                i = i + 1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Total No of vertices");
        int vertex = sc.nextInt();
        GraphTopologicallSort obj = new GraphTopologicallSort(vertex);
        System.out.println("Minimum Number of Edges");
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            System.out.println("Start of the Edge ");
            int Start = sc.nextInt();
            System.out.println("end of the Edge ");
            int end = sc.nextInt();
            addEdge(Start, end, false);
        }
        bfsStart(0, vertex);
        startTopologicalSort();
    }
}
