package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11655 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) { // 소문자라면
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            } else if (Character.isUpperCase(c)) { // 대문자라면
                sb.append((char) ((c - 'A' + 13) % 26 + 'A'));
            } else {
                // 그 외 문자는 그냥 출력
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
