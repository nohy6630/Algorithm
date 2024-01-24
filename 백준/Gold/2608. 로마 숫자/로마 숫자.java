import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Map<Integer, String> HM = new HashMap<>();
    Map<Character, Integer> arabia = new HashMap<>();

    String num2arabia(int num) {
        List<Integer> digit = new ArrayList<>(HM.keySet());
        Collections.sort(digit, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int d : digit) {
            while (num >= d) {
                num -= d;
                sb.append(HM.get(d));
            }
        }
        return sb.toString();
    }

    int arabia2num(String str) {
        int tmp = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (arabia.get(c) > tmp)
                tmp = arabia.get(c) - tmp;
            else {
                if (i != 0)
                    ret += tmp;
                tmp = arabia.get(c);
            }
        }
        ret += tmp;
        return ret;
    }

    void solution() throws Exception {
        HM.put(1, "I");
        HM.put(2, "II");
        HM.put(3, "III");
        HM.put(4, "IV");
        HM.put(5, "V");
        HM.put(6, "VI");
        HM.put(7, "VII");
        HM.put(8, "VIII");
        HM.put(9, "IX");
        HM.put(10, "X");
        HM.put(20, "XX");
        HM.put(30, "XXX");
        HM.put(40, "XL");
        HM.put(50, "L");
        HM.put(60, "LX");
        HM.put(70, "LXX");
        HM.put(80, "LXXX");
        HM.put(90, "XC");
        HM.put(100, "C");
        HM.put(200, "CC");
        HM.put(300, "CCC");
        HM.put(400, "CD");
        HM.put(500, "D");
        HM.put(600, "DC");
        HM.put(700, "DCC");
        HM.put(800, "DCCC");
        HM.put(900, "CM");
        HM.put(1000, "M");
        HM.put(2000, "MM");
        HM.put(3000, "MMM");
        arabia.put('I', 1);
        arabia.put('V', 5);
        arabia.put('X', 10);
        arabia.put('L', 50);
        arabia.put('C', 100);
        arabia.put('D', 500);
        arabia.put('M', 1000);
        int a = arabia2num(br.readLine());
        int b = arabia2num(br.readLine());
        System.out.println(a + b);
        System.out.println(num2arabia(a + b));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}