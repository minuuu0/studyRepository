package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumAlgo {
    public static void main(String[] args) throws IOException {
        // 등차수열의 누적합 값 구해보기
        // (1이상 1이하의 모든 자연수의 합) + (1이상 2이하의 모든 자연수의 합) + ... +(1이상 N이하의 모든 자연수의 합)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n까지의 등차주열 누적합 구하기 100이라면 171700

        int answer = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= i; j++){
                sum += j;
            }
            answer += sum;
        }
        System.out.println(answer);
    }
}
