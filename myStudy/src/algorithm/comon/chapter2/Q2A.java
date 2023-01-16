package algorithm.comon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2A {

    // n개의 도토리에 대한 키와 생일정보가 주어진다 (키는 오름차순으로 제공)
    // 이 때 이번달에 생일이 있는 도토리중 가장 큰 도토리의 키를 출력하자

    // 입력 형식
    // 첫 줄에는 도토리수(n)를 입력
    // 두번째 줄에는 도토리의 키를 입력(오름차순)
    // 세번째 줄에는 n개의 도토리들의 생일 입력
    // 네번째 줄에는 현재의 달(m)을 입력한다 (해당 달에 도토리가 없을 경우 -1 출력)
    public static int getMaximumHeight(int[] height, int[] month, int n, int m){
        int maxHeight = -1; // 해당 달에 도토리가 없을 경우 -1을 출력하기에 초기값을 -1로 준다
        for(int i = n - 1; i >= 0; i--){ // 어처피 키는 오름차순이기에 뒤에서부터 순차적으로 탐색하면 가장 큰 도토리를 찾을 수 있다
            if(m == month[i]){
                maxHeight = height[i];
                break;
            }
        }
        return maxHeight;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도토리 갯수 n을 입력
        int[] height = new int[n];
        int[] month = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            height[i] = Integer.parseInt(st.nextToken());
            month[i] = Integer.parseInt(st1.nextToken());
        }
        int answer = getMaximumHeight(height, month, n, m);
        System.out.println(answer);
    }
}
