package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Bj1107 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());
        boolean[] breaks = new boolean[10];


        if(m > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                breaks[Integer.parseInt(st.nextToken())] = true; // 고장난 버튼 true표시
            }
        }

        int result = Math.abs(n - 100); // 위와 같이 설정하면 min값은 무조건 0이됨
        for(int i = 0; i <= 999999; i++){ // 9를 제외하고 모두 고장나면 999999까지 탐색

            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++){
                if(breaks[str.charAt(j) - '0']){ // 고장난 버튼 클릭시
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) { // 고장난 버튼을 누르지 않는다면
                int min = Math.abs(n - i) + len;
                result = Math.min(min, result);
            }

        }
        System.out.println(result);

    }

}
