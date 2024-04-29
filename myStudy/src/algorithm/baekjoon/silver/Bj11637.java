package algorithm.baekjoon.silver;
import java.io.*;
import java.util.*;
public class Bj11637
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException
    {
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int sum = 0, max = 0, winner = 0;

            for (int i = 0; i < n; i++) {
                int vote = Integer.parseInt(br.readLine());

                if (vote > max) {
                    max = vote;
                    winner = i + 1;
                } else if (vote == max) {
                    winner = -1;
                }
                sum += vote;
            }
            if (winner == -1) {
                System.out.println("no winner");
            } else if (max > sum / 2) {
                System.out.println("majority winner " + winner);
            } else {
                System.out.println("minority winner " + winner);
            }


        }
    }
}
