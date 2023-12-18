package algorithm.baekjoon.foundation.graph;

import java.io.*;
import java.util.*;

public class Bj13023 {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int N, M;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N]; // 리스트 객체 배열 선언 but 인스턴스 초기화 X
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>(); // 인접 리스트를 이용함
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b); // 인접리스트 값 추가
            adjList[b].add(a);
        }

        // 친구관계가 m에 맞으면 되니

        for (int i = 0; i < N; i++) { // 모든 정점에 대해
            visited = new boolean[N]; // 방문여부 초기화
            dfs(i, 0); // dfs 수행

            // 결과값 로직
            if (found) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static void dfs(int node, int depth) {
        if (depth == 4) { // 만약 친구관계가 4-depth라면 친구관계가 조건에 맞다.
            found = true;
            return;
        }

        visited[node] = true; // 정점 방문시 방문 표시
        for (int nextNode : adjList[node]) { // 인접한 모든 정점에 대해
            if (!visited[nextNode]) { // 방문하지 않은 노드라면
                dfs(nextNode, depth + 1); // 해당 노드로 재귀호출
                if (found) return;
            }
        }
        visited[node] = false; // Backtracking
    }
}
