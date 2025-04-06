package algorithm.prepare.backtracking;

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n, m;
    static int[] area;
    static int[] board;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());
        area = new int[m];
        board = new int[n];
        visited = new boolean[n];
        
        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(board);
        func(0);
        System.out.println(sb);
    }

    static void func(int depth) {
        if (depth == m) {
            for (int n : area) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && prev != board[i]) {
                area[depth] = board[i];
                visited[i] = true;
                func(depth + 1);
                visited[i] = false;
                prev = board[i];
            }
        }
        
    }
}