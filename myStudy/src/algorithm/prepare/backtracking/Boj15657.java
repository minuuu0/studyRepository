package algorithm.prepare.backtracking;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] area;
    static int[] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());
        area = new int[M];
        board = new int[N];
        
        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(board);
        func(0, 0);
        System.out.println(sb);
    }

    static void func(int depth, int prev) {
        if (depth == M) {
            for (int n : area) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (prev <= board[i]) {
                area[depth] = board[i];
                func(depth + 1, board[i]);   
            }
        }
    }
}