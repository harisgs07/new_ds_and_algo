import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GraphPond {

    static ArrayList<ArrayList<Integer>> adjList;

    public GraphPond(int vertex) {
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<>());
    }

    static void addedges(int start, int end, boolean bidirection, int vertex) {
        adjList.get(start).add(end);
        if (bidirection)
            adjList.get(end).add(start);
    }

    static boolean dfs(boolean[] visited, ArrayList<Integer> ans, int source, int vertex, boolean[] recurStack) {
        recurStack[source] = true;
        visited[source] = true;
        ans.add(source);
        for (int i : adjList.get(source)) {
            if (!visited[i]) {
                if (dfs(visited, ans, i, vertex, recurStack))
                    return true;
            } else if (recurStack[i]) {
                System.out.println("Detect Cycle at " + source + " --> " + i);
                return true;
            }
        }
        recurStack[source] = false;
        return false;
    }

    static void detectCycle(int source, int vertex) {
        boolean recurStack[] = new boolean[vertex];

        boolean visited[] = new boolean[vertex];
        Arrays.fill(visited, false);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean returnValue = dfs(visited, ans, source, vertex, recurStack);
        if (returnValue)
            return;
        for (int i = 0; i < vertex; i++) {
            if (!visited[i])
                if (dfs(visited, ans, i, vertex, recurStack))
                    return;
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
        GraphPond obj = new GraphPond(vertex);
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter Start ");
            int start = sc.nextInt();
            System.out.println("Enter end");
            int end = sc.nextInt();
            // System.out.println("Enter Direction if bidirectional true else false ");
            // Boolean direction = sc.nextBoolean();
            addedges(start, end, false, vertex);
        }

        System.out.println("DFS ");
        detectCycle(0, vertex);

    }
}
