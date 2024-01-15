package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2250_2 {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] parentNode;
    static ArrayList<Integer>[] node;
    static int count;

    static int[] min; // 각 레벨별 최소 열 번호를 저장할 배열
    static int[] max; // 각 레벨별 최대 열 번호를 저장할 배열

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        min = new int[n + 1];
        max = new int[n + 1];

        parentNode = new int[n + 1]; // 1based
        node = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            node[i] = new ArrayList<>();
        }

        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(parentNode, -1); // 부모 노드를 전체 -1로 채움

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken()); // 부모노드
            int ln = Integer.parseInt(st.nextToken());
            int rn = Integer.parseInt(st.nextToken());
            node[value].add(ln);
            node[value].add(rn);

            if (ln != -1) {
                parentNode[ln] = value;
            }

            if (rn != -1) {
                parentNode[rn] = value;
            }
        }



        // 트리의 너비 탐색
        for (int i = 1; i <= n; i++) { // 부모 순회
            if (parentNode[i] == -1) { // 부모가 없는 노드 순회
                inOrder(i, 1); // 너비 탐색
            }
        }

//        inOrder(1, 1);


        // 최대 너비와 그 레벨 찾기
        int idx = 1; // 최대 너비의 레벨을 저장
        for (int i = 2; i <= n; i++) { // 각 레벨을 탐색
            if (min[i] <= max[i]) { // 레벨마다 최대값이 더 크다면
                if (max[i] - min[i] + 1 > max[idx] - min[idx] + 1) {
                    idx = i;
                }
            }
        }

        System.out.println(idx + " " + (max[idx] - min[idx] + 1));

    }

    private static void inOrder(int cur,int depth) {
        if (node[cur].get(0) != -1) { // 왼쪽 노드가 있으면 dfs
            inOrder(node[cur].get(0), depth + 1);
        }

        count++; // 열 번호를 할당하기 위한 카운터

        min[depth] = Math.min(min[depth], count); // 현재 깊이에서 가장 작은 열 번호 저장
        max[depth] = Math.max(max[depth], count);

        if (node[cur].get(1) != -1) { // 오른쪽 노드가 있는지 확인
            inOrder(node[cur].get(1), depth + 1);
        }
    }

}
