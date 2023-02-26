package algorithm.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj4153 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static boolean checkRightTriangle(int x, int y, int z) {
        if(x * x + y * y == z * z){
            return true;
        }else if (y * y + z * z == x * x){
            return true;
        } else if (x * x + z * z == y * y) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0 && z == 0){
                break;
            }

            boolean answer = checkRightTriangle(x, y, z);

            if(answer){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}
