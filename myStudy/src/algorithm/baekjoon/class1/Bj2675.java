package algorithm.baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2675 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void testCase(int caseIndex) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()); // 반복 횟수 r
        String p = st.nextToken(); // 반복할 문자열

        for(int j = 0; j < p.length(); j++){
            for(int i = 0; i < r; i++){
                System.out.print(p.charAt(j));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int caseSize = Integer.parseInt(br.readLine());

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex+=1){
            testCase(caseIndex);
        }

    }
}
