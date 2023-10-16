package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14889 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    // idx는 인덱스, count := 조합 개수(재귀 깊이)
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(min);


    }

    private static void combi(int idx, int count) {
        // 팀 조합이 완성 될 경우
        if (count == n / 2) {
            // 점수를 구해 최솟값을 찾음
            diff();
            return;
        }

        for(int i = idx; i < n; i++){ // (1, 2) (2,1)과 같은 중복 케이스 방지를 위한 idx
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }

    }

    private static void diff() {

        int team_start = 0;
        int team_link = 0;

        for(int i = 0; i < n - 1; i++){ // i번째 선수
            for(int j = i + 1; j < n; j++){ // j번째 선수, j는 항상 i보다 크다(중복 방지)
                // true = start팀
                if (visited[i] == true && visited[j] == true) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                }

                if (visited[i] == false && visited[j] == false) {
                    team_link += map[j][i];
                    team_link += map[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(team_link - team_start));

    }

}
