package algorithm.baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj8958 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int cnt(String nextToken) { // OO
        int cnt = 0;
        for(int i = 0; i < nextToken.length(); i++){ // 2
            cnt = cnt + i + 1;
        }
        return cnt;
    }

    private static void testCase(int caseIndex) throws IOException{
        // O가 연속으로 있을 수록 1점씩 증가
        StringTokenizer st = new StringTokenizer(br.readLine(), "X");
        int score = 0;

        while (st.hasMoreTokens()){
            score += cnt(st.nextToken());
        }
        System.out.println(score);
    }

    public static void main(String[] args) throws IOException {
        int caseSize = Integer.parseInt(br.readLine());

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
