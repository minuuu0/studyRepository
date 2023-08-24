package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15649 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] selected; // 선택된 수열을 저장할 배열 m개 ex) 1 2, 1 3, 1 4 etc..
    static boolean[] visited; // 각 숫자의 방문 여부를 체크할 배열 1based

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m];
        visited = new boolean[n + 1];

        solve(0); // 수열 생성 시작
    }

    private static void solve(int depth) {
        if(depth == m){ // m개 만큼의 수열
            for(int num : selected){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++){ // 1 ~ n
            if(!visited[i]){ // 방문 여부 체크
                selected[depth] = i; // 현재 깊이의 위치에 수를 넣음
                visited[i] = true; // 해당 숫자 방문처리
                solve(depth + 1); // 다음 깊이로 이동(재귀)
                visited[i] = false; // 백트래킹을 위해 방문표시 제거
            }
        }

    }
}
