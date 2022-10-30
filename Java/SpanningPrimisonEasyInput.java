import java.sql.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SpanningPrimisonEasyInput {
    static boolean[] visited;

    public SpanningPrimisonEasyInput(int vertex) {
        visited = new boolean[vertex];
        Arrays.fill(visited, false);
    }

    static PriorityQueue<int[]> val = new PriorityQueue<>();

    static void getPrimsAlgo(int[][] edges, int vertex, int start) {
        int ans = 0;
        val.add(edges[0]);
        while (!val.isEmpty()) {
            int[] cur = val.poll();
            int i = 0; // chumma ettaeyaa
            int src = edges[i][0];
            int dest = edges[i][1];
            int weigh = edges[i][2];
            if (visited[src])
                continue;
            else {
                ans = ans + weigh;
                visited[dest] = true;
            }
        }

        System.out.println("Ans" + ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Vertices Graph Have ");
        int vertex = sc.nextInt();
        SpanningPrimisonEasyInput obj = new SpanningPrimisonEasyInput(vertex);
        int[][] edges = { { 0, 1, 2 }, { 0, 3, 7 }, { 0, 4, 6 }, { 1, 4, 4 }, { 1, 2, 1 }, { 2, 4, 2 }, { 2, 3, 3 },
                { 3, 4, 5 },
                { 1, 0, 2 }, { 3, 0, 7 }, { 4, 0, 6 }, { 4, 1, 4 }, { 2, 1, 1 }, { 4, 2, 2 }, { 3, 2, 3 },
                { 4, 3, 5 } };
        getPrimsAlgo(edges, vertex, 0);

    }

}
