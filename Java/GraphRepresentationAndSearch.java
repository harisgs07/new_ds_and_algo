import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GraphRepresentationAndSearch {

    int[][] addEdgeMatrix(int[][] matrixGraph, int start, int end, boolean bidirection) {

        matrixGraph[start][end] = 1;
        if (bidirection)
            matrixGraph[end][start] = 1;
        return matrixGraph;
    }

    void print(int[][] matrixGraph) {
        for (int i = 0; i < matrixGraph.length; i++) {
            for (int j = 0; j < matrixGraph.length; j++) {
                if (matrixGraph[i][j] == 1) {
                    System.out.println(i + " --> " + j);
                }
            }
        }
    }

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of vertices Graph Have");
        int vertex = sc.nextInt();
        int matrixGraph[][] = new int[vertex][vertex];
        for (int[] i : matrixGraph) {
            Arrays.fill(i, 0);
        }
        GraphRepresentationAndSearch obj = new GraphRepresentationAndSearch();
        matrixGraph = obj.addEdgeMatrix(matrixGraph, 1, 2, true);
        matrixGraph = obj.addEdgeMatrix(matrixGraph, 1, 5, true);
        matrixGraph = obj.addEdgeMatrix(matrixGraph, 1, 4, true);
        matrixGraph = obj.addEdgeMatrix(matrixGraph, 5, 3, true);
        matrixGraph = obj.addEdgeMatrix(matrixGraph, 4, 5, true);
        matrixGraph = obj.addEdgeMatrix(matrixGraph, 2, 4, true);
        obj.print(matrixGraph);

        // Need To inistialise each index with arrayList type
        ArrayList<ArrayList<Integer>> adjListGraph = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            adjListGraph.add(new ArrayList<>());
        }

        adjListGraph = obj.addEdgeList(adjListGraph, 1, 2, true);
        adjListGraph = obj.addEdgeList(adjListGraph, 1, 0, true);
        adjListGraph = obj.addEdgeList(adjListGraph, 1, 4, true);
        adjListGraph = obj.addEdgeList(adjListGraph, 5, 3, false);
        adjListGraph = obj.addEdgeList(adjListGraph, 4, 5, true);
        adjListGraph = obj.addEdgeList(adjListGraph, 2, 4, true);

        obj.printList(adjListGraph);
    }
}
