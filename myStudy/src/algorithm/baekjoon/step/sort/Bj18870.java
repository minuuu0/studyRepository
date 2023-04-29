package algorithm.baekjoon.step.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Bj18870 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] origin = new int[n]; // 원본 배열
        int[] sorted = new int[n]; // 정렬 할 배열
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            sorted[i] = origin[i] = sc.nextInt();
        }

        Arrays.sort(sorted); // 정렬 수행

            int rank = 0;
            for(int v : sorted){ // v : 정렬 된 데이터

                // 만약 앞 선 원소가 이미 순서가 정해졌다면 중복처리를 위해 map에 원소와 그에 대응되는 순위를 넣어준다.
                if(!map.containsKey(v)){
                    map.put(v, rank++);
                }

            }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(origin[i])).append(" ");
        }
        System.out.println(sb);

    }
}
