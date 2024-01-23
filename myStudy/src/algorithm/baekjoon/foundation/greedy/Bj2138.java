package algorithm.baekjoon.foundation.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj2138 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] origin, target;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        origin = new int[n];
        target = new int[n];

        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            origin[i] = input.charAt(i) - '0';
        }

        input = br.readLine();

        for (int i = 0; i < n; i++) {
            target[i] = input.charAt(i) - '0';
        }

        // 2중 for문은 시간초과가 발생하니 -> for문을 한 번만 돌려야한다.

        int res1 = solve(true); // 첫 전구를 누르는 경우
        int res2 = solve(false); // 첫 전구를 누르지 않는 경우 -> 두 시나리오에 따라 결과가 달라지니 구별함(첫 전구 -> i, i + 1만 탐색), 나머지 전구 -> i - 1, i, i + 1로 탐색해야하기에)

        int result = Math.min(res1, res2);
        System.out.println(result >= 100000 ? -1 : result);

    }

    private static int solve(boolean flipFirst) {
        int[] bulbs = Arrays.copyOf(origin, n); // 현재 전구 상태 복사
        int count = 0;

        // 첫 전구를 누를 경우
        if (flipFirst) {
            flip(bulbs, 0);
            count++;
        }

        // 전구 배열을 순회하며 상태를 확인하고 필요한 경우 전구를 누름
        for (int i = 1; i < n; i++) {
            if (bulbs[i - 1] != target[i - 1]) {
                flip(bulbs, i);
                count++;
            }
        }

        // 최종 상태가 목표 상태와 같은지 확인
        if (Arrays.equals(bulbs, target)) {
            return count;
        } else {
            return 100000; // 목표 상태에 도달하지 못한 경우 큰 수 반환
        }

    }

    // 주어진 인덱스의 전구와 양 옆의 전구를 바꾸는 함수
    private static void flip(int[] bulbs, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < n) {
                bulbs[i] = 1 - bulbs[i];
            }
        }
    }

}
