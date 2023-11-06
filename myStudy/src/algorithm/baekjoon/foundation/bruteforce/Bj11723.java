package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11723 {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int bitset = 0; // 20bit Integer

        // 3에 데이터가 있으면 1000, 4에 데이터가 있으면 10000 데이터가 존재한 곳에 1처리

        while ( n-- > 0 ) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if(operation.equals("all")) bitset = (1 << 21) - 1; // s를 1, 2, 3... 20으로
            else if (operation.equals("empty")) bitset = 0; // 공집합
            else{
                int num = Integer.parseInt(st.nextToken());

                if(operation.equals("add"))
                    bitset = bitset | (1 << num); // add 3 := 1000 / 1000  <<  add 4 := 1000 | 10000 := 11000

                else if (operation.equals("remove")) {
                    bitset = bitset & ~(1 << num); // remove 4 -> 11000 & 01111 = 01000 | rem 3 = 1000 & 0111 = 0000
                }

                else if (operation.equals("check")) { // check 4 -> 11000일때
                    // (bitset & (1 << num)) != 0 ? 1 : 0
                    if ((bitset & (1 << num)) != 0) {
                        sb.append(1).append("\n");
                    }else {
                        sb.append(0).append("\n");
                    }

                } else if (operation.equals("toggle")) {
                    bitset = bitset ^ (1 << num);
                }
            }

        }

        System.out.println(sb);
    }

}
