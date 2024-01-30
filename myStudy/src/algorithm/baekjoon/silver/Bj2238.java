package algorithm.baekjoon.silver;

import java.lang.*;
import java.io.*;
import java.util.*;

class Bj2238
{


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main (String[] args) throws IOException
    {

        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken()); // 가격의 상한
        int N = Integer.parseInt(st.nextToken()); // 경매 참여 횟수

        int[] price = new int[U + 1]; // 가격의 개수를 보관
        String[] name = new String[U + 1]; // 가격을 기준으로 배열 생성

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            Integer p = Integer.parseInt(st.nextToken());

            if (name[p] == null) name[p] = n; // 이름은 1회만 추가
            price[p]++;
        }

        // 초기화
        int min = N + 1; //
        int index = 0;

        for (int i = 1; i < price.length; i++) { // 각 가격 순회
            if (price[i] != 0 && price[i] < min) {  // 0은 가격이 등록안됨을 의미, min은 최솟값을 얻기위함
                min = price[i];
                index = i;
            }
        }

        System.out.println(name[index] + " " + index);

    }
}