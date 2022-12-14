import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BFSforNonConnected {

    ArrayList<ArrayList<Integer>> addEdgeList(ArrayList<ArrayList<Integer>> adjListGraph, int start, int end,
            boolean bidirection) {
        adjListGraph.get(start).add(end);
        if (bidirection)
            adjListGraph.get(end).add(start);
        return adjListGraph;
    }

    void printList(ArrayList<ArrayList<Integer>> adjListGraph) {
        for (ArrayList<Integer> i : adjListGraph)
            System.out.println(adjListGraph.indexOf(i) + " ---> " + i);
    }

    void printBFS(ArrayList<ArrayList<Integer>> adjListGraph, int source, int vertex, boolean[] visited) {

        visited[source] = true;
        ArrayDeque<Integer> verty = new ArrayDeque<>();
        verty.offer(source);

        System.out.print(source + " ");

        while (!verty.isEmpty()) {
            int temp = verty.poll();
            for (int j : adjListGraph.get(temp)) {
                if (visited[j] == false) {
                    verty.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }

        for (int i = 1; i < vertex; i++) {
            if (visited[i] == false) {
                printBFS(adjListGraph, i, vertex, visited);
            }
        }
    }

    boolean check(boolean[] checkvisited) {
        for (boolean i : checkvisited) {
            if (i == false)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BFSforNonConnected obj = new BFSforNonConnected();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of vertices Graph Have");
        int vertex = sc.nextInt() + 1;

        // Need To inistialise each index with arrayList type
        ArrayList<ArrayList<Integer>> adjListGraph = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            adjListGraph.add(new ArrayList<>());
        }

        adjListGraph = obj.addEdgeList(adjListGraph, 1, 2, true);
        // adjListGraph = obj.addEdgeList(adjListGraph, 1, 5, true);
        adjListGraph = obj.addEdgeList(adjListGraph, 1, 4, true);
        adjListGraph = obj.addEdgeList(adjListGraph, 5, 3, false);
        // adjListGraph = obj.addEdgeList(adjListGraph, 4, 5, true);
        adjListGraph = obj.addEdgeList(adjListGraph, 2, 4, true);
        obj.printList(adjListGraph);
        boolean visited[] = new boolean[vertex];
        Arrays.fill(visited, false);
        obj.printBFS(adjListGraph, 2, vertex, visited);
    }
}
