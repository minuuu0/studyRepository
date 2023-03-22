package algorithm.baekjoon.step.intensification1;

import java.util.Scanner;

public class Bj1316 {
    static final Scanner sc = new Scanner(System.in);

    private static boolean checkGroup() {
        String s = sc.next();
        int prev = 0; // 비교할 값
        boolean[] check = new boolean[26];

        // 빈도수 테이블을 만들어 각 단어별로 순회하며 이전에 있던 단어인지 확인한다

        for(int j = 0; j < s.length(); j++){
            int now = s.charAt(j); // 현재 알파벳

            if(prev != now){ // 앞선 문자와 j번째 문자가 연속이지 않을때

                if(check[now - 97] == false){ // 해당 문자가 처음 나오는 경우
                    check[now - 97] = true;
                    prev = now;
                }else{ // 해당 문자가 또 나오는 경우
                    return false;
                }

            }

        }
        return true;
    }

    public static void main(String[] args) {
        // 그룹 단어 체크하기
        int n = sc.nextInt(); // 단어의 수 입력

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(checkGroup() == true){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
