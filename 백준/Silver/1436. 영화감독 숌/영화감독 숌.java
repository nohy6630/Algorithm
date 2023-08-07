import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N;
    long ans = 666;
    int idx = 0;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (true) {
            if (String.valueOf(ans).contains("666"))
                idx++;
            if(idx==N)
                break;
            ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}