package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj11724 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }


        int cnt = 0;
        for (int i = 1; i <= n; i++) { // 모든 정점에 대해 조사
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);


    }

    private static void bfs(int v) {
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(v);

        while (!que.isEmpty()) {
            Integer poll = que.poll();
            for (Integer adj : list[poll]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    que.add(adj);
                }
            }
        }
    }
}
