package algorithm.baekjoon.foundation.graph;

import java.io.*;
import java.util.*;

public class Bj2250 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] min; // 각 레벨별 최소 열 번호를 저장할 배열
    static int[] max; // 각 레벨별 최대 열 번호를 저장할 배열
    static int[] parent; // 각 노드의 부모 노드를 저장할 배열
    static int count; // 열 번호를 할당하기 위한 카운터
    static ArrayList<Integer>[] tree; // 트리를 저장할 리스트 배열

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // 초기화
        min = new int[n + 1];
        max = new int[n + 1]; // 1based
        parent = new int[n + 1]; // 부모 관계를 표현할 배열
        tree = new ArrayList[n + 1]; // 트리를 리스트로 표현, 각 노드를 배열 N개로 선언 tree[1] = 1번노드의 트리 표현
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(parent, -1); // 부모 노드를 전체 -1로 채움

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int ln = Integer.parseInt(st.nextToken());
            int rn = Integer.parseInt(st.nextToken());
            tree[value].add(ln);
            tree[value].add(rn);
            if (ln != -1) {
                parent[ln] = value;
            }
            if (rn != -1) {
                parent[rn] = value;
            }
        }


        // 트리의 너비 탐색
        for (int i = 1; i <= n; i++) { // 부모 순회
            if (parent[i] == -1) { // 부모가 없는 노드 순회
                dfs(i, 1); // 너비 탐색
            }
        }

        // 최대 너비와 그 레벨 찾기
        int idx = 1;
        for (int i = 2; i <= n; i++) {
            if (min[i] <= max[i]) {
                if (max[i] - min[i] + 1 > max[idx] - min[idx] + 1) {
                    idx = i;
                }
            }
        }

        System.out.println(idx + " " + (max[idx] - min[idx] + 1));


    }


    public static void dfs(int cur, int depth) { // cur:= 현재 노드, depth := 현재 깊이

        if (tree[cur].get(0) != -1) {  // 왼쪽 노드가 존재하는지 확인
            dfs(tree[cur].get(0), depth + 1); // 있으면 재귀적 호출
        }
        count++; // 각 노드의 열번호 중위 순회이므로 현재 노드를 방문하기 전에 증가
        min[depth] = Math.min(min[depth], count); // 현재 깊이에서 가장 작은 열 번호 저장
        max[depth] = Math.max(max[depth], count);
        if (tree[cur].get(1) != -1) { // 오른쪽 노드가 존재하는지 확인
            dfs(tree[cur].get(1), depth + 1);
        }
    }

}
