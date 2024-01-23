import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        long n = Long.parseLong(br.readLine());
        if (n % 7 == 0 || n % 7 == 2)
            System.out.println("CY");
        else
            System.out.println("SK");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}