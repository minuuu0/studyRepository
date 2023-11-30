package algorithm.baekjoon.foundation.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11723 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int bit = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            switch (op) {
                case "add":
                    bit = bit | (1 << x - 1);
                    break;

                case "remove":
                    bit = bit & ~(1 << x - 1);
                    break;

                case "check":
                    System.out.println((bit & (1 << (x - 1))) != 0 ? 1 : 0);
                    break;

                case "toggle":
                    bit = bit ^ (1 << x);
                    break;

                case "all":
                    bit = (1 << 21) - 1;
                    break;

                case "empty":
                    bit = 0;
                    break;

            }

        }

    }

}
