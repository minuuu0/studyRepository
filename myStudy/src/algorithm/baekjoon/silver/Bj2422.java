import java.lang.*;
import java.io.*;
import java.util.*;

class Bj2422
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws IOException
    {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] forbidden = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            forbidden[num1][num2] = true;
            forbidden[num2][num1] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for(int k = j + 1; k <= n; k++) {
                    if (!forbidden[i][j] && !forbidden[i][k] && !forbidden[j][k]){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}