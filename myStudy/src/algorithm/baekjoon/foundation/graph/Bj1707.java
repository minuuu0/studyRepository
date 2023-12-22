package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj1707 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors; // 0 = 방문x 1= 방문 색1, 2 = 방문 색2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>(); // 그래프를 담을 리스트 선언
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            colors = new int[v + 1];

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            if (isBipartiteGraph(v)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isBipartiteGraph(int v) {
        for (int i = 1; i <= v; i++) { // 모든 정점에 대해
            if (colors[i] == 0 && !dfs(i, 1)) { // 정점i가 방문되지 않았고, 이분그래프가 아닌경우
                return false;
            }
        }
        return true;
    }

    static boolean dfs(int node, int color) { // true = 이분그래프, false = 이분그래프 아님
        colors[node] = color; // 방문처리
        for (int neighbor : graph.get(node)) {
            if (colors[neighbor] == 0) {  // 인접 노드가 방문하지 않은 경우
                if (!dfs(neighbor, 3 - color)) { // 현재 정점과 다른 색을 부여해 탐색한다.
                    return false;
                }
            } else if (colors[neighbor] == colors[node]) { // 인접 노드가 현재 노드와 색이 같다면
                return false;
            }
        }
        return true;
    }
}
