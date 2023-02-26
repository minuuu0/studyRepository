package algorithm.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10250 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void testCase(int caseIndex) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // 건물의 높이
        int w = Integer.parseInt(st.nextToken()); // 건물의 너비
        int n = Integer.parseInt(st.nextToken()); // n 번째 손님

        int y = n % h == 0 ? h : n % h; // 꼭대기 층이면 h, 아니면 n % h
        int x = n % h == 0 ? n / h : n / h + 1; // 꼭대기 층이면 n / h, 아니면 n / h + 1
        // n = 층 수
        System.out.println(y * 100 + x);

    }

    public static void main(String[] args) throws IOException {
        int caseSize = Integer.parseInt(br.readLine());

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
