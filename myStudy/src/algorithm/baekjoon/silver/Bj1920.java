package algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1920 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] A;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }



    }

    static int binarySearch(int key) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (key < A[mid]) {
                end = mid - 1;
            } else if (key > A[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }

        }

        return -1;
    }
}
