import java.util.*;
import java.io.*;

public class Main
{
    static Long N;
    static final int MOD = 1000000007;

    static long[][] dq(long n)
    {
        long[][] ret = {
            {1, 1},
            {1, 0}
        };
        if (n == 1)
            return ret;
        long[][] val = dq(n/2);
        for(int i=0; i<2; i++)
        {
            for(int j=0; j<2; j++)
            {
                ret[i][j]=0;
                for(int k=0; k<2; k++)
                    ret[i][j] += val[i][k] * val[k][j] % MOD;
                ret[i][j]%=MOD;
            }
        }
        if (n%2 == 1)
        {
            long[][] tmp = {
                {(ret[0][0] + ret[0][1])%MOD, ret[0][0]},
                {(ret[1][0] + ret[1][1])%MOD, ret[1][0]}
            };
            ret = tmp;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long[][] ret = dq(N);
        System.out.print(ret[0][1]);
    }
}