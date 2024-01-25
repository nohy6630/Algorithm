import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        System.out.println(n * (n - 1) * (n - 2) * (n - 3) / 24);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}