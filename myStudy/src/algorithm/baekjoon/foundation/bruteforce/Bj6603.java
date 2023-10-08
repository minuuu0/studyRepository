package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj6603 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int k;
    static int[] arr;
    static int[] area = new int[6];
    static boolean[] visited;

    private static void dfs(int depth, int start) {
        if(depth == 6){ // 로또 자리 수
            for (int i : area) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < k; i++){
            if (!visited[i]) {
                visited[i] = true;
                area[depth] = arr[i];
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        while (true){
            sb.setLength(0);

            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if(k == 0){
                return;
            }
            arr = new int[k];
            visited = new boolean[k];

            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            System.out.println(sb);
        }
    }

}
