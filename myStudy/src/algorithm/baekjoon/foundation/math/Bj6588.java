package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj6588 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] prime = new boolean[1000001]; // true면 지워진 것
    private static void getPrime() {
        prime[0] = prime[1] = true;
        // 에라토스테네스의 체 구현
        for(int i = 2; i <= Math.sqrt(1000001); i++){ // O(100만)
            // 자신을 제외한 배수 지우기
            if(prime[i] == true){ // 지워진다면 건너뛴다
                continue;
            }
            // 해당 수의 배수 만큼 지운다
            for(long j = (long)i * i; j < 1000001; j += i){ // 2 * i가 아닌 i * i가 가능한 이유는 이미 직전의 배수에서 지웠을 것
                prime[(int)j] = true;
            }
        }

    }

    private static int getMin(int num) {
        for(int i =1; i <= num; i+=2){
            if(prime[i] == false){ // 소수를 찾아
                if(prime[num - i] == false){
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        // 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다. ex) 8 = 3 + 5 / 20 = 3 + 17, 7 + 13 /
        // 소수 판별
        getPrime();// O(N)
        while (true){ // 테케 값이 최대 10만이니 에라토스테네스의 체로 미리 배열을 할당 후 이를 재활용하자.
            int num = Integer.parseInt(br.readLine()); // 값 입력
            if(num == 0){
                break; // 테케 프로그램 종료
            }


            int demical = getMin(num);
            System.out.println(num +" = " + demical +" + " + (num - demical));
        }
    }
}
