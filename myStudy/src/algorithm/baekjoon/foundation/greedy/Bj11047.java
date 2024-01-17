package algorithm.baekjoon.foundation.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11047 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류 & 개수
        int k = Integer.parseInt(st.nextToken()); // 목표 가치
        int cnt = 0;

        int[] arr = new int[n]; // 동전을 보관하는 배열

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i >= 0; i--) {

            if (k / arr[i] != 0) { // 나누어 떨어짐
                cnt = cnt + k / arr[i];
                k %= arr[i];
            }

        }

        System.out.println(cnt);


        /* 아래 코드를 사용하려면 위의 풀이를 주석처리해야함(k값이 변하기 때문)
        int[] dp = new int[k + 1]; // dp[i] = i를 만들기 위해 필요한 최소 동전의 수
        // case2 만약 dp로 푼다면? -> O(n*k)의 시간복잡도로 인해 시간 초과되나 이런 방법도 있다는걸 기억하자.
        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0; // 0원으로 만드는데 필요한 동전의 수 는 0개

        // 목표가 4200(k)이라고 가정
        for (int i = 0; i < n; i++) { // 금액 i를 만드는데 필요한 최소 동전 수
            for (int j = arr[i]; j <= k; j++) { // arr[i]는 동전의 값, -> 1원이면 1 ~ 4200 , 5원이면 5 ~ 4200, 10~ 4200...
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        System.out.println(dp[k]);


         */

    }

}
