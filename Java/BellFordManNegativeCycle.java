import java.util.Arrays;
import java.util.Scanner;

public class BellFordManNegativeCycle {

    static int[] ans;

    public BellFordManNegativeCycle(int vertex) {
        ans = new int[vertex];
        Arrays.fill(ans, Integer.MAX_VALUE);
    }

    static void getShortestPath(int[][] edges, int vertex, int first) {
        ans[first] = 0;
        if (checkNegativeCycle(edges, vertex))
            System.out.println("Negative Cycle Detected");
        else {
            for (int i = 0; i < vertex; i++)
                System.out.println("From " + edges[0][0] + " --> " + i + " : " + ans[i]);
        }

    }

    static boolean checkNegativeCycle(int[][] edges, int vertex) {

        for (int k = 1; k < vertex; k++) {
            for (int i = 0; i < edges.length; i++) {
                int start = edges[i][0];
                int destination = edges[i][1];
                int weight = edges[i][2];
                if (ans[start] + weight < ans[destination] && ans[start] != Integer.MAX_VALUE)
                    ans[destination] = ans[start] + weight;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int destination = edges[i][1];
            int weight = edges[i][2];
            if (ans[start] + weight < ans[destination] && ans[start] != Integer.MAX_VALUE)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of Vertices ");
        int vertex = sc.nextInt();
        System.out.println("Start at ");
        int first = sc.nextInt();
        int[][] edges = { { 0, 1, 3 }, { 0, 2, 1 }, { 1, 2, -4 }, { 3, 1, 4 }, { 2, 3, 2 } };
        BellFordManNegativeCycle obj = new BellFordManNegativeCycle(vertex);
        getShortestPath(edges, vertex, first);

    }
}
