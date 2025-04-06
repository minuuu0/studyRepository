package algorithm.prepare.backtracking;

import java.io.*;
import java.lang.*;
import java.util.*;

// The main method must be in a class named "Main".
class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] area = new int[6];
    static int n;
    static int[] board;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            n = Integer.parseInt(s.nextToken());
            if (n == 0) break;
            board = new int[n];
            for (int i = 0; i < n; i++) {
                board[i] = Integer.parseInt(s.nextToken());
            }
            Arrays.sort(board);
            func(0, -1);

            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    static void func(int depth, int prevIdx) {
        // System.out.println("1");
        if (depth == 6) {
            for (int n : area) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = prevIdx; i < n; i++) {
            if (i > prevIdx) {
                area[depth] = board[i];
                func(depth + 1, i);
            }
        }
    }
}