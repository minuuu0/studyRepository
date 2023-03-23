package algorithm.baekjoon.step.array2;

import java.util.Scanner;

public class Bj10798 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        char[][] ch = new char[5][15]; // 5개의 단어와 단어의 길이는 최대 15임
        int max = 0;

        for(int i = 0; i < ch.length; i++){
            String str = sc.next();

            if(max < str.length()) max = str.length(); // 단어 마다 최대값 갱신

            for(int j = 0; j < str.length(); j++){ // 단어의 길이만큼 반복
                ch[i][j] = str.charAt(j); // 해당 단어를 2차원 배열에 추가
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < max; i++){ // 단어의 최대만큼 반복
            for(int j = 0; j < 5; j++){ // 단어의 개수는 5개임
                if(ch[j][i] == '\0') continue; // char배열의 초기값은 '\0'  < 값이 비면 continue
                sb.append(ch[j][i]);
            }
        }
        System.out.println(sb);

    }
}
