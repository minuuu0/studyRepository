package algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj20365 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[n];

        String str = br.readLine();
        for (int i = 0; i < n; i++) { // 500,000
            arr[i] = str.charAt(i);
        }

        int rValue = 0; // 연속적인 빨강의 수
        int bValue = 0;

        for (int i = 0; i < n; i++) {
            char c = arr[i]; // 선택된 색
            if (i == 0) { // 첫 값
                if (c == 'B') {
                    bValue++;
                } else {
                    rValue++;
                }
            } else { // 첫 값이 아닌 경우
                if (arr[i - 1] == c) { // 이전과 같은 색일 경우
                    continue;
                } else { // 이전과 다른 색일 경우
                    if (c == 'B') {
                        bValue++;
                    } else {
                        rValue++;
                    }
                }
            }
        }

        int res = 0;
        if (bValue > rValue) { // 파랑이 더 많은 경우
            res = rValue + 1;
        } else {
            res = bValue + 1;
        }

        System.out.println(res);

    }

}
