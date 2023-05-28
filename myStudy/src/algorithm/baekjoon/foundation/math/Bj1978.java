package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1978 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0; // 소수 개수

        for(int j = 0; j < n; j++){
            int num = Integer.parseInt(st.nextToken()); // 소수 판별
            // 소수라면 공약수가 없다. 공약수가 존재한다면 공약수에 대응하는 수가 있다. ex) 6 = 1, 2, 3, 6 (2, 3) (1, 6)대응 4라면 2 스스로 대응
            // 그러니 공약수가 있다고 가정을 하고 sqrt(n)

            if(num == 1){
                continue;
            }
            if(num == 2){ // 2는 짝수고
                cnt++;
                continue;
            } else if (num % 2 == 0) { // 2를 제외한 짝수는 탐색 안해도됨
                continue;
            }

            boolean isPrime = true; // 소수 체크

            for(int i = 3; i <= (int)Math.sqrt(num); i++){ // 3까지는 소수이고 홀수 9부터 약수가 있으니 i = 3부터 탐색
                if(num % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
