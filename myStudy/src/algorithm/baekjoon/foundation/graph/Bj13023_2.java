package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj13023_2 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static StringTokenizer st;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean check;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a); // 인접 리스트 활용
        }

        for (int i = 0; i < n; i++) { // 모든 정점에 대해 친구 관계를 검사해 depth가 4인지 확인해야한다.
            dfs(i, new boolean[n]);

            if (check) {
                System.out.println(1);
                return; // 메인 메소드 종료
            }
        }
        System.out.println(0);


    }

    private static void dfs(int start, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) { // 스택이 비지 않을때
            int current = stack.pop();

            if (adj[current].size() == 4) {
                check = true;
                return;
            }

            for (Integer next : adj[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
    }

}
