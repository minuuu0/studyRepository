package algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj16471 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] customer = new int[n];
        int[] ceo = new int[n];
        boolean[] cards = new boolean[n]; // 카드 사용 여부

        StringTokenizer st = new StringTokenizer(br.readLine()); // 손님 입력

        for (int i = 0; i < n; i++) {
            customer[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()); // 사장님 입력
        for (int i = 0; i < n; i++) {
            ceo[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ceo);
        Arrays.sort(customer);

        int index = 0;
        int count = 0;
        for (int i = 0; i < n; i++) { // 손님은 사장보다 작을 때만 인덱스 증가
            if (customer[index] < ceo[i]) {
                count++;
                index++;
            }
        }

        if (count >= ((n + 1) / 2))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
