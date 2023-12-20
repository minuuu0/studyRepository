package algorithm.baekjoon.foundation.graph;

import java.io.*;
import java.util.*;

public class Bj1260_2 {
    static int n, m, v;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1]; // 1based
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        check = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        dfs(v);
        System.out.println();
        check = new boolean[n + 1];
        bfs(v);

    }

    private static void bfs(int v) {
        Queue<Integer> que = new LinkedList();
        check[v] = true;
        que.add(v);

        while (!que.isEmpty()) {
            Integer poll = que.poll();
            System.out.print(poll + " ");
            for (Integer adj : list[poll]) {
                if (!check[adj]) {
                    check[adj] = true;
                    que.add(adj);
                }
            }
        }

    }

    private static void dfs(int v) {
        check[v] = true;
        System.out.print(v + " ");

        for (Integer adjVertex : list[v]) { // 각 인접한 정점에 대해
            if (!check[adjVertex]) { // 방문하지 않은 정점이라면
                dfs(adjVertex);
            }
        }
    }

}
