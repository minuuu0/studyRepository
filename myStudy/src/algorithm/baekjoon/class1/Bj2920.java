package algorithm.baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2920 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[8];
        String ans = "";

        for(int i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for(int i = 0; i+1 < 8; i++){
            if(arr[i] == arr[i + 1] + 1){
                ans = "descending";
            }else if(arr[i] == arr[i + 1] - 1){
                ans = "ascending";
            }else{
                ans = "mixed";
                break;
            }
        }
        System.out.println(ans);

    }
}
