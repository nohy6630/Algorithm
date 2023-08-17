import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str, bombStr;
    Deque<Character> S = new ArrayDeque<>();
    Deque<Character> backup = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    void solution() throws IOException {
        str = br.readLine();
        bombStr = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            S.push(str.charAt(i));
            if (S.size() >= bombStr.length()) {
                for (int j = bombStr.length() - 1; j >= 0; j--) {
                    backup.push(S.remove());
                    if (backup.element() != bombStr.charAt(j))
                        break;
                    if (j == 0)
                        backup.clear();
                }
                while (!backup.isEmpty())
                    S.push(backup.remove());
            }
        }
        if (S.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        while (!S.isEmpty())
            sb.append(S.remove());
        System.out.println(sb.reverse().toString());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}