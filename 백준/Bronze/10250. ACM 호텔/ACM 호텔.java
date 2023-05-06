import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int H=sc.nextInt();
            sc.nextInt();
            int N=sc.nextInt();
            int floor=(N%H==0)?H:N%H;
            int room=(N%H==0)?N/H:N/H+1;
            System.out.println(floor+String.format("%02d",room));
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
