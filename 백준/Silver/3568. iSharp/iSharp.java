import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    void solution() throws Exception {
        String input = br.readLine();
        input = input.replaceAll("[,;]", "");
        String[] str = input.split(" ");
        for (int i = 1; i < str.length; i++) {
            StringBuilder type = new StringBuilder(str[0]);
            StringBuilder name = new StringBuilder();
            int idx = 0;
            while (idx < str[i].length() && Character.isAlphabetic(str[i].charAt(idx))) {
                name.append(str[i].charAt(idx));
                idx++;
            }
            for (int j = str[i].length() - 1; j >= idx; j--) {
                if (str[i].charAt(j) == ']') {
                    type.append("[]");
                    j--;
                } else
                    type.append(str[i].charAt(j));
            }
            sb.append(type + " " + name + ";\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}