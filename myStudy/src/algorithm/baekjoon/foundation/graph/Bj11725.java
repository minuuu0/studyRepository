package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj11725 {

    static int n;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] result;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1]; // 1based
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            adj[num1].add(num2);
            adj[num2].add(num1);

        }

        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            for (Integer ad : adj[poll]) {
                if (!visited[ad]) {
                    visited[ad] = true;
                    q.add(ad);
                    result[ad] = poll;
                }
            }
        }

    }

}
