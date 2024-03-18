import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int t, n;
    String vegetable, result;
    Set<Character> type = new HashSet<>();
    Map<Character, Character> winVegetable = new HashMap<>();
    Map<Character, Character> loseVegetable = new HashMap<>();

    boolean solve() throws Exception {
        type.clear();
        n = Integer.parseInt(br.readLine());
        vegetable = br.readLine();
        result = br.readLine();
        if (result.contains("D")) {
            if (result.contains("W") || result.contains("L"))
                return false;
            for (int i = 0; i < result.length(); i++) {
                if (vegetable.charAt(i) == '?')
                    continue;
                type.add(vegetable.charAt(i));
            }
            String replace;
            if (type.size() == 1) {
                replace = type.stream().collect(Collectors.toList()).get(0) + "";
            } else if (type.size() == 2) {
                List<Character> types = type.stream().collect(Collectors.toList());
                replace = "GOD";
                replace = replace.replaceAll("[" + types.get(0) + types.get(1) + "]", "");
            } else
                replace = "G";
            vegetable = vegetable.replaceAll("\\?", replace);
        } else {
            if (!result.contains("W") || !result.contains("L"))
                return false;
            char win = 0, lose = 0;
            for (int i = 0; i < result.length(); i++) {
                char v = vegetable.charAt(i);
                if (v == '?')
                    continue;
                if (result.charAt(i) == 'W') {
                    if (win != 0 && win != v)
                        return false;
                    win = v;
                } else {
                    if (lose != 0 && lose != v)
                        return false;
                    lose = v;
                }
            }
            if (win == 0 && lose == 0) {
                win = 'G';
                lose = 'O';
            } else if (win == 0)
                win = loseVegetable.get(lose);
            else if (lose == 0)
                lose = winVegetable.get(win);
            else if (win != loseVegetable.get(lose) || lose != winVegetable.get(win))
                return false;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < result.length(); i++) {
                if (vegetable.charAt(i) != '?') {
                    res.append(vegetable.charAt(i));
                    continue;
                }
                if (result.charAt(i) == 'W')
                    res.append(win);
                else
                    res.append(lose);
            }
            vegetable = res.toString();
        }
        return true;
    }

    void solution() throws Exception {
        t = Integer.parseInt(br.readLine());
        winVegetable.put('G', 'O');
        winVegetable.put('O', 'D');
        winVegetable.put('D', 'G');
        loseVegetable.put('G', 'D');
        loseVegetable.put('O', 'G');
        loseVegetable.put('D', 'O');
        for (int i = 0; i < t; i++) {
            boolean ret = solve();
            if (ret)
                sb.append("YES\n" + vegetable + "\n");
            else
                sb.append("NO\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}