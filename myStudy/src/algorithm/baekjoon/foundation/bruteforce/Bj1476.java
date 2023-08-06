package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1476 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int earth = 1, sun = 1, moon = 1;
        int cnt = 1;
        while (earth != e || sun != s || moon != m){
            earth++;
            sun++;
            moon++;

            if(earth > 15){
                earth = 1;
            }
            if(sun > 28){
                sun = 1;
            }
            if(moon > 19){
                moon = 1;
            }

            cnt ++;
        }
        System.out.println(cnt);

    }

}
