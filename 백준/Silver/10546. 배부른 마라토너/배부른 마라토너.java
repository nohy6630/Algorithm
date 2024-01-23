import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;
    Map<String, Integer> HM = new HashMap<>();
    List<String> names = new ArrayList<>();

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            names.add(name);
        }
        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            HM.put(name, HM.getOrDefault(name, 0) + 1);
        }
        for (String name : names) {
            if (HM.get(name) == null || HM.get(name) <= 0) {
                System.out.println(name);
                break;
            }
            HM.put(name, HM.get(name) - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}