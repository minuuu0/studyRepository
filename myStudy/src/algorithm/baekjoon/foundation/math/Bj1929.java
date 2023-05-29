package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1929 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        // M 이상 N 이하의 소수를 모두 출력하라 1 ~ 100만이니 O(N LOG N) 내에 수행해야한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1]; // 소수가 아니면 true로 바꿔준다. 0은 쓰지 않는다.
        arr[0] = arr[1] = true;
        // 에라토스테네스의 체 적용
        for(int i = 2; i <= Math.sqrt(arr.length); i++){ // <= 주의
            // 자기를 제외한 배수를 지우는데 그 전에 지웠다면 넘어간다.
            if(arr[i] == true){
                continue;
            }
            // 소수가 아니라면 자신을 제외한 배수를 지운다
            for(int j = i * i; j < arr.length; j = j + i){
                arr[j] = true;
            }
        }

        for(int i = M; i <= N; i++){ // 소수 판별
            if(!arr[i]){ // 소수인 원소는
                System.out.println(i);
            }
        }

    }
}
