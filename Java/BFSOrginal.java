import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BFSOrginal {

    static ArrayList<ArrayList<Integer>> adjList;

    public BFSOrginal(int vertex) {
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertex; i++)
            adjList.add(new ArrayList<>());
    }

    static void addedges(int start, int end, boolean bidirection, int vertex) {
        adjList.get(start).add(end);
        if (bidirection)
            adjList.get(end).add(start);
    }

    static ArrayList<Integer> bfs(boolean[] visited, int source, int vertex, ArrayList<Integer> ans,
            ArrayDeque<Integer> que) {
        visited[source] = true;
        ans.add(source);
        que.offer(source);
        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int i : adjList.get(temp)) {
                if (!visited[i]) {
                    que.add(i);
                    visited[i] = true;
                    ans.add(i);
                }
            }
        }
        for (int j = 1; j < vertex; j++) {
            if (!visited[j])
                bfs(visited, j, vertex, ans, que);
        }
        return ans;
    }

    static void printBfsStarts(int source, int vertex) {
        boolean visited[] = new boolean[vertex];
        Arrays.fill(visited, false);
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        ans = bfs(visited, source, vertex, ans, que);
        for (int i : ans)
            System.out.print(i + " ");
        System.out.println();
    }

    static void dfs(boolean[] visited, ArrayList<Integer> ans, int source, int vertex) {
        visited[source] = true;
        ans.add(source);
        for (int i : adjList.get(source)) {
            if (!visited[i])
                dfs(visited, ans, i, vertex);
        }
    }

    static void printDfsStarts(int source, int vertex) {
        boolean visited[] = new boolean[vertex];
        Arrays.fill(visited, false);
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(visited, ans, source, vertex);
        for (int i = 1; i < vertex; i++) {
            if (!visited[i])
                dfs(visited, ans, i, vertex);
        }
        for (int j : ans)
            System.out.print(j + " ");
    }

    static void minDistance(int source, int destination, int vertex) {
        int parent[] = new int[vertex];
        boolean visited[] = new boolean[vertex];
        Arrays.fill(visited, false);
        int distance = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        System.out.println("Distance is : " + findDist(source, destination, vertex, visited, que, distance, parent));
    }

    static int findDist(int source, int destination, int vertex, boolean[] visited, ArrayDeque<Integer> que,
            int distance, int[] parent) {
        visited[source] = true;
        que.offer(source);
        parent[source] = -1;

        while (!que.isEmpty()) {
            int temp = que.poll();
            if (temp == destination)
                break;
            for (int i : adjList.get(temp)) {
                if (!visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                    parent[i] = temp;
                }
            }
        }

        int temp = destination;
        while (parent[temp] != -1) {
            System.out.print(temp + " --> ");
            temp = parent[temp];
            distance++;
        }
        return distance;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Vertex ");
        int vertex = sc.nextInt() + 1;
        System.out.println("Enter The min Number Of Edges ");
        int edges = sc.nextInt();
        BFSOrginal obj = new BFSOrginal(vertex);
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter Start ");
            int start = sc.nextInt();
            System.out.println("Enter end");
            int end = sc.nextInt();
            // System.out.println("Enter Direction if bidirectional true else false ");
            // Boolean direction = sc.nextBoolean();
            addedges(start, end, true, vertex);
        }

        System.out.println("BFS ");
        printBfsStarts(4, vertex);
        System.out.println("DFS ");
        printDfsStarts(4, vertex);
        System.out.println("Min distance to the destination from source");
        System.out.println("Enter the destination from the source");
        int destination = sc.nextInt();
        minDistance(4, destination, vertex);
    }
}
