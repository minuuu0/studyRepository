package algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj1058_dfs {
    static int n;
    static char[][] friend;
    static boolean[] visited;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        friend = new char[n][n];
        for (int i = 0; i < n; i++) {
            friend[i] = br.readLine().toCharArray(); // 인접행렬 값 삽입
        }


        for (int i = 0; i < n; i++) {
            visited = new boolean[n]; // 순회마다 방문여부 초기화
            visited[i] = true;

            Queue<Integer> que = new LinkedList<>();
            que.add(i);

            int depth = 0;
            int cnt = 0;

            // 2-친구이기에 뎁스 제한
            while (depth < 2) {
                int size = que.size();
                for (int j = 0; j < size; j++) {
                    int num = que.poll();

                    // n번째 행의 열 데이터 탐색
                    for (int k = 0; k < n; k++) {
                        if (friend[num][k] == 'Y' && !visited[k]) { // Y이며 방문하지 않은 데이터에 대해
                            que.add(k); // 큐에 삽입해 탐색하게 함
                            cnt++;
                            visited[k] = true;
                        }
                    }
                }
                depth++;
            }
            if (maxCount < cnt) {
                maxCount = cnt;
            }
        }

        System.out.println(maxCount);

    }

}
