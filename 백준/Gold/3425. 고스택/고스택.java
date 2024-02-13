import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String solve(List<String> program, long n) {
        Deque<Long> S = new ArrayDeque<>();
        S.add(n);
        try {
            for (String input : program) {
                if (input.startsWith("NUM")) {
                    S.addFirst(Long.parseLong(input.split(" ")[1]));
                } else if (input.equals("POP"))
                    S.removeFirst();
                else if (input.equals("INV"))
                    S.addFirst(S.removeFirst() * (-1));
                else if (input.equals("DUP"))
                    S.addFirst(S.element());
                else if (input.equals("SWP")) {
                    long a = S.removeFirst();
                    long b = S.removeFirst();
                    S.addFirst(a);
                    S.addFirst(b);
                } else if (input.equals("ADD")) {
                    long a = S.removeFirst();
                    long b = S.removeFirst();
                    S.addFirst(b + a);
                } else if (input.equals("SUB")) {
                    long a = S.removeFirst();
                    long b = S.removeFirst();
                    S.addFirst(b - a);
                } else if (input.equals("MUL")) {
                    long a = S.removeFirst();
                    long b = S.removeFirst();
                    S.addFirst(b * a);
                } else if (input.equals("DIV")) {
                    long a = S.removeFirst();
                    long b = S.removeFirst();
                    if (a == 0)
                        throw new Exception();
                    long num = Math.abs(b) / Math.abs(a);
                    if ((a < 0 && b >= 0) || (a >= 0 && b < 0)) {
                        S.addFirst(-num);
                    } else
                        S.addFirst(num);
                } else if (input.equals("MOD")) {
                    long a = S.removeFirst();
                    long b = S.removeFirst();
                    if (a == 0)
                        throw new Exception();
                    long num = Math.abs(b) % Math.abs(a);
                    if (b >= 0)
                        S.addFirst(num);
                    else
                        S.addFirst(-num);

                }
                if (!S.isEmpty() && Math.abs(S.element()) > 1_000_000_000)
                    throw new Exception();
            }
        } catch (Exception e) {
            return "ERROR";
        }
        if (S.size() != 1)
            return "ERROR";
        return String.valueOf(S.element());
    }

    void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        boolean end = false;
        while (true) {
            List<String> program = new ArrayList<>();
            String input;
            while (true) {
                input = br.readLine();
                if (input.equals("QUIT") || input.equals("END"))
                    break;
                program.add(input);
            }
            if (input.equals("QUIT"))
                break;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++)
                sb.append(solve(program, Long.parseLong(br.readLine()))).append('\n');
            sb.append('\n');
            br.readLine();
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}