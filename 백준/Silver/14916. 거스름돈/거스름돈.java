import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;


    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int a = n/5;
        if(a>0 && n%2!=a%2)
            a--;
        n -= (a*5);
        if(n%2 != 0)
            System.out.println(-1);
        else
            System.out.println(a+n/2);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}