package algorithm.baekjoon.step.sort;

import java.util.*;
public class Bj11651 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[]o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];  // 음수가 나오면 우선순위가 낮다
                }else{
                    return o1[1] - o2[1];  // 양수가 나오면 우선순위가 높다
                }
            }
        });

        for(int[] a : arr){
            System.out.println(a[0] + " " +a[1]);
        }

    }
}
