import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GrapCycleDetect {

    static ArrayList<ArrayList<Integer>> adjList;

    public GrapCycleDetect(int vertex) {
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<>());
    }

    static void addedges(int start, int end, boolean bidirection, int vertex) {
        adjList.get(start).add(end);
        if (bidirection)
            adjList.get(end).add(start);
    }

    static boolean dfs(boolean[] visited, ArrayList<Integer> ans, int source, int vertex, int[] parent) {

        visited[source] = true;
        ans.add(source);
        for (int i : adjList.get(source)) {
            if (!visited[i]) {
                parent[i] = source;
                if (dfs(visited, ans, i, vertex, parent))
                    return true;
            } else if (visited[i] && parent[source] != i) {
                System.out.println("Detected cycle and exiting at " + i + " --> " + source);
                return true;
            }
        }
        return false;
    }

    static void printDfsStarts(int source, int vertex) {
        int parent[] = new int[vertex];
        parent[source] = -1;
        boolean visited[] = new boolean[vertex];
        Arrays.fill(visited, false);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean returnValue = dfs(visited, ans, source, vertex, parent);
        if (returnValue)
            return;
        for (int i = 0; i < vertex; i++) {
            if (!visited[i])
                returnValue = dfs(visited, ans, i, vertex, parent);
        }

        for (int j : ans)
            System.out.print(j + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Vertex ");
        int vertex = sc.nextInt();
        System.out.println("Enter The min Number Of Edges ");
        int edges = sc.nextInt();
        GrapCycleDetect obj = new GrapCycleDetect(vertex);
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter Start ");
            int start = sc.nextInt();
            System.out.println("Enter end");
            int end = sc.nextInt();
            // System.out.println("Enter Direction if bidirectional true else false ");
            // Boolean direction = sc.nextBoolean();
            addedges(start, end, true, vertex);
        }

        System.out.println("DFS ");
        printDfsStarts(0, vertex);

    }
}
