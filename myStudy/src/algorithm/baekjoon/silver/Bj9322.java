package algorithm.baekjoon.silver;

import java.lang.*;
import java.util.*;
import java.io.*;

class Bj9322
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] nor;
    static String[] sec;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main (String[] args) throws IOException
    {

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sec = new String[n];
            nor = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String key = st.nextToken();
                map.put(key, i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String key = st.nextToken();
                nor[i] = map.get(key);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                sec[nor[i]] = st.nextToken();
            }

            for (int i = 0; i < n; i++) {
                System.out.print(sec[i] + " ");
            }
            System.out.println();


        }
    }
}