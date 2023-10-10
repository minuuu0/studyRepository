package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1759 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int l, c;
    static char[] arr;
    static char[] area;

    private static void dfs(int depth, int start) {
        if(depth == l){
            if(isValid()){
                System.out.println(area);
            }
            return;
        }

        for(int i = start; i < c; i++){
            area[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }

    private static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : area) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        area = new char[l];

        arr = new char[c];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < c; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        // 배열 정렬 사전순
        Arrays.sort(arr);

        dfs(0, 0);


    }
}
