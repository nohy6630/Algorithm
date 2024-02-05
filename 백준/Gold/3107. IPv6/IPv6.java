import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String input;

    String fillZero(String str) {
        while (str.length() < 4)
            str = "0" + str;
        return str;
    }

    void solution() throws Exception {
        input = br.readLine();
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ':')
                cnt++;
        }
        String colon = "";
        for (int i = cnt - 2; i < 7; i++)
            colon += ":";
        input = input.replaceAll("::", colon);
        if (input.charAt(input.length() - 1) == ':')
            input += "0";
        String[] num = input.split(":");
        for (int i = 0; i < num.length; i++) {
            if (i != 0)
                System.out.print(":");
            System.out.print(fillZero(num[i]));
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}