import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    String s;
    int i;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        i = Integer.parseInt(br.readLine());
        System.out.println(s.charAt(i - 1));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}