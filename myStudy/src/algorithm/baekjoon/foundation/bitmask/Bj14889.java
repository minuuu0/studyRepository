package algorithm.baekjoon.foundation.bitmask;

import algorithm.baekjoon.foundation.bruteforce.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj14889 {
    static int n;
    static int[][] ability;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < (1 << n); i++){
            ArrayList<Integer> team1 = new ArrayList<>();
            ArrayList<Integer> team2 = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    team1.add(j);
                } else {
                    team2.add(j);
                }
            }

            if (team1.size() != n / 2) continue; // 팀이 구성되지 않으면 continue

            int diff = Math.abs(calculateAbility(team1) - calculateAbility(team2));
            minDiff = Math.min(minDiff, diff);

        }

    }

    private static int calculateAbility(ArrayList<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i != j) {
                    sum += ability[team.get(i)][team.get(j)];
                }
            }
        }
        return sum;
    }

}
