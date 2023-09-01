package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15649_2 {

    static boolean[] visited;
    static int[] area;
    static int m, n;

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void solve(int k) {

        if(k == m){ // 공간이 다 채워지면 출력
            for (int i : area) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                area[k] = i;
                visited[i] = true;
                solve(k + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        area = new int[m];

        solve(0);

    }

}
