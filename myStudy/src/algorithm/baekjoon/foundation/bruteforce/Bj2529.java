package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj2529 {

    static int n;
    static boolean[] visited = new boolean[10];
    static List<String> result = new ArrayList<>();
    static char[] signs;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        signs = new char[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            signs[i] = st.nextToken().charAt(0);
        }

        dfs("",0); // 문자열과 depth

        System.out.println(result.get(result.size() - 1)); // 최댓값
        System.out.println(result.get(0)); // 최솟값

    }

    private static void dfs(String num, int depth) { // num := 정수 문자데이터
        if (depth == n + 1) {
            result.add(num);
            return;
        }

        for(int i = 0; i <= 9; i++){
            if (!visited[i]) {
                if(depth == 0 || check(signs[depth - 1], num.charAt(depth - 1), (char)(i + '0'))){
                    visited[i] = true;
                    dfs(num + i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean check(char sign, char num1, char num2) {
        if (sign == '<') {
            if(num1 < num2) return true;
        }else{
            if(num1 > num2) return true;
        }
        return false;
    }

}
