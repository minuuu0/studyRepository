package algorithm.baekjoon.silver;

import java.lang.*;
import java.util.*;
import java.io.*;

class Bj2993
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws IOException
    {

        String str = br.readLine();

        int length = str.length();

        // 가장 작은 단어
        for (int i = 1; i < length; i++) { // i := index
            for (int j = i + 1; j < length; j++) {
                String first = new StringBuilder(str.substring(0, i)).reverse().toString();
                String second = new StringBuilder(str.substring(i, j)).reverse().toString();
                String third = new StringBuilder(str.substring(j)).reverse().toString();


                String res = first + second + third;

                if (res.compareTo(str) < 0) {
                    str = res;
                }

            }

        }

        System.out.println(str);

    }
}
