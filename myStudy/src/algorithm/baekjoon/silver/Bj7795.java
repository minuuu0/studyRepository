package algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj7795 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {


        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // a의 개수
            int m = Integer.parseInt(st.nextToken()); // b의 개수

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine()); // a 입력
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()); // b 입력
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);

            int count = 0;
            for (int i = 0; i < n; i++) {
                count += lowerBound(b, a[i]); // A[i] 보다 작은 B배열의 원소 개수를 찾아 더함
            }

            System.out.println(count);

        }

    }

    private static int lowerBound(int[] b, int target) {
        int left = 0;
        int right = b.length;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (b[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // left는 target보다 작은 원소들의 수

    }

}
