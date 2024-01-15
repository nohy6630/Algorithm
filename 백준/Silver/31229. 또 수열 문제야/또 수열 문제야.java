import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(i*2+1);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
