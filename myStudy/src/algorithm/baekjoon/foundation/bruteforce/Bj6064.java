package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean check = false;

            for(int i = x; i <= n * m; i += m){
                // i:= x가 나올 수 있는 경우의 수이니 y만 비교하면 된다.
                if(i % n == y){
                    System.out.println(i);
                    check = true; // 나올 수 있는 경우의 수가 있다면 true
                    break;
                }
            }

            for (int i = x; i <= n * m; i += m) {
                int mod = (i % n == 0) ? n : i % n; // y 값을 구함 := i % n==0이라면 n으로 설정

                if (mod == y) {
                    System.out.println(i);
                    check = true;
                    break;
                }
            }

            if(!check){ // 경우의 수가 없다면
                System.out.println(-1);
            }
        }
    }
}
