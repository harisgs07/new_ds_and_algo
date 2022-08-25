import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class aaaa {

    public static void main(String[] args)  {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in));

        String[] input = new String[2];
        int a;
        int b;

        System.out.print("Please enter two integers: ");
        input = in.readLine().split(" ");

        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        System.out.println("You input: " + a + " and " + b);
    }

}
