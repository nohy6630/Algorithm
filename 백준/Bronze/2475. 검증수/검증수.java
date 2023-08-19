import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    void solution() throws IOException {
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum += n * n;
        }
        System.out.println(sum % 10);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}