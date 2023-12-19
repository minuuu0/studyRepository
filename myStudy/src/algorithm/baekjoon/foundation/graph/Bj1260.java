package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Bj1260 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] list;
    static int[] area;
    static int n;
    static boolean[] visited;
    static boolean check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // vertex  1based
        int m = Integer.parseInt(st.nextToken()); // edge
        int v = Integer.parseInt(st.nextToken()); // 탐색 start

        area = new int[n];
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // 각 인접 리스트 정렬
        for (int i = 1; i <= n; i++) { // 최악의 경우 O(n * k * log(k)
            Collections.sort(list[i]);
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
    }

    private static void dfs(int start) { // O(V+E) 시간복잡도
        // 내가 첨 짠 이상한 코드..
/*        area[depth] = start;
        if (depth == n - 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(area[i] + " ");
            }
            System.out.println();
            check = true;
            return;
        }

        visited[start] = true;
        for (Integer node : list[start]) {
            if (!visited[node]) {
                dfs(node, depth + 1);
                if(check) return;
            }
        }
        visited[start] = false;
 */
        visited[start] = true;
        System.out.print(start + " ");

        for (Integer integer : list[start]) {
            if (!visited[integer]) {
                dfs(integer);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Integer next : list[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }
    }

}
