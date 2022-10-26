import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFSforNonConnected {

    static ArrayList<ArrayList<Integer>> addEdgeList(ArrayList<ArrayList<Integer>> adjListGraph, int start, int end,
            boolean bidirection) {
        adjListGraph.get(start).add(end);
        if (bidirection)
            adjListGraph.get(end).add(start);
        return adjListGraph;
    }

    static void printList(ArrayList<ArrayList<Integer>> adjListGraph) {
        for (ArrayList<Integer> i : adjListGraph)
            System.out.println(adjListGraph.indexOf(i) + " ---> " + i);
    }

    static ArrayList<Integer> printDFS(ArrayList<ArrayList<Integer>> adjListGraph, int source, int vertex) {

        boolean visited[] = new boolean[vertex];
        Arrays.fill(visited, false);
        ArrayList<Integer> ans = new ArrayList<>();

        dfs(adjListGraph, source, vertex, visited, ans);

        for (int i = 1; i < vertex; i++) {
            if (visited[i] == false) {
                dfs(adjListGraph, i, vertex, visited, ans);
            }
        }

        return ans;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adjListGraph, int source, int vertex, boolean[] visited,
            ArrayList<Integer> ans) {

        visited[source] = true;
        ans.add(source);
        for (int j : adjListGraph.get(source)) {
            if (visited[j] == false) {
                dfs(adjListGraph, source, vertex, visited, ans);
            }
        }
    }

    public static void main(String[] args) {
        DFSforNonConnected obj = new DFSforNonConnected();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of vertices Graph Have");
        int vertex = sc.nextInt() + 1;

        // Need To inistialise each index with arrayList type
        ArrayList<ArrayList<Integer>> adjListGraph = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            adjListGraph.add(new ArrayList<>());
        }

        addEdgeList(adjListGraph, 1, 2, true);
        // adjListGraph = obj.addEdgeList(adjListGraph, 1, 5, true);
        addEdgeList(adjListGraph, 1, 4, true);
        addEdgeList(adjListGraph, 5, 3, true);
        // adjListGraph = obj.addEdgeList(adjListGraph, 4, 5, true);
        addEdgeList(adjListGraph, 2, 4, true);
        printList(adjListGraph);

        ArrayList<Integer> last = new ArrayList<>();
        last = printDFS(adjListGraph, 2, vertex);
    }
}
