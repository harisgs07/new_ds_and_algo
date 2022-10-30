import java.util.Scanner;

public class disjointUsingMatrixMakeFriends {

    static int[][] matrixFriend;

    public disjointUsingMatrixMakeFriends(int vertex) {
        matrixFriend = new int[vertex][vertex];
    }

    static void makeFriends(int a, int b, int vertex) {
        matrixFriend[a][b] = 1;
        matrixFriend[b][a] = 1;
        for (int i = 0; i < vertex; i++) {
            if (matrixFriend[b][i] == 1) {
                matrixFriend[a][i] = 1;
                matrixFriend[i][a] = 1;
            }
            if (matrixFriend[a][i] == 1) {
                matrixFriend[b][i] = 1;
                matrixFriend[i][b] = 1;
            }
        }
    }

    static void areFriends(int a, int b) {
        if (matrixFriend[a][b] == 1)
            System.out.println("are Friends");
        else
            System.out.println("Not Friend");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        disjointUsingMatrixMakeFriends obj = new disjointUsingMatrixMakeFriends(vertex);
        makeFriends(0, 1, vertex);
        makeFriends(2, 7, vertex);
        makeFriends(3, 6, vertex);
        areFriends(0, 2);
        makeFriends(0, 7, vertex);
        // makeFriends(0, 1, vertex);
        // makeFriends(0, 1, vertex);
        areFriends(0, 2);
        // makeFriends(0, 1, vertex);
    }
}
