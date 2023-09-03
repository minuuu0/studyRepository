package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15650 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static boolean[] checked; // 중복 확인을 위한 배열
    static int[] arr; // 배열에 들어갈 수 있는 값
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        checked = new boolean[n + 1]; // n개의 값의 중복체크(1based)
        arr = new int[m];

        backTracking(0, 1); // 0번 인덱스부터 시작, 1부터 시작하도록 수정
    }

    private static void backTracking(int k, int start) {
        if(k == m){ // k가 m개라면 배열의 값이 꽉찼다는 것이니 배열값을 출력한다
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            return; // 재귀를 위한 리턴
        }

        for(int i = start; i <= n; i++){ // i := n이 들어갈 수 있는 수
            if(!checked[i]){ // 중복은 참여 x

                checked[i] = true; // i번째 체크 표시
                arr[k] = i; // 배열에 값 추가
                backTracking(k + 1, i + 1);
                checked[i] = false; // 백트래킹
            }
        }

    }
}
