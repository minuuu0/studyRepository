package algorithm.comon.chapter5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Q5H { // 중복 제거\
    static final Scanner sc = new Scanner(System.in);
    static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = sc.nextInt(); // 숫자의 개수

        HashSet<Integer> integers = new HashSet<>(); // unordered set 자료구조

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();

            if(integers.contains(x)){
                writer.write("DUPLICATED\n");
            }else{
                integers.add(x);
                writer.write("OK\n");
            }
        }
        writer.flush();
        writer.close();
    }
}
