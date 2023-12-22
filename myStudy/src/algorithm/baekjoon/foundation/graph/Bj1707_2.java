package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1707_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int v, e;
    static ArrayList<Integer>[] adjList;
    static int[] visited; // 0 : 방문x, 1 : 방문o 1번색, 2 : 방문o 2번색

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());

        while (x-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            boolean found = false;

            adjList = new ArrayList[v + 1];
            visited = new int[v + 1];

            for (int i = 0; i <= v; i++) {
                adjList[i] = new ArrayList<>();
            }


            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adjList[a].add(b);
                adjList[b].add(a);
            }

            for (int i = 1; i <= v; i++) {
                if (visited[i] == 0) { // 방문하지 않았다면
                    found = bfs(i);
                }
                if (!found) break;
            }
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

    private static boolean bfs(int node) {
        visited[node] = 1;
        Queue<Integer> que = new LinkedList<>();

        que.add(node);

        while (!que.isEmpty()) {
            Integer poll = que.poll();
            for (Integer adj : adjList[poll]) {
                if (visited[adj] == 0) { // 방문하지 않은 정점에 대해
                    visited[adj] = 3 - visited[poll]; // 이전과 다른 방문표시
                    que.add(adj);
                } else if (visited[adj] == visited[poll]) {
                    return false;
                }
            }
        }
        return true;

    }

}
