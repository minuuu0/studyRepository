package algorithm.comon.chapter4;

import java.util.ArrayList;
import java.util.Scanner;

// probing 문제풀이
public class Q4B {
    public static final Scanner sc = new Scanner(System.in);
    private static ArrayList<Integer>  getTicketNumbers(int n, int m, int[] idx) {
        boolean[] used = new boolean[n]; // 이 티켓이 사용중인지 판단하는 배열 초기값은 false
        ArrayList<Integer> tickets = new ArrayList<>();

        for(int ticket : idx){ // 모든 티켓번호에 대해
            int index = ticket % n; // 회원번호를 티켓번호로 나눈 나머지값(행운권)이 탐색할 인덱스이다.
            while (used[index] == true){ // 회원이 있으면 위치를 옮겨야함
                index = index + 1 % n; // 0으로 돌아가기위해 나머지 연산
            }
            tickets.add(index); // 티켓번호값 저장
            used[index] = true; // 해당 번호는 이제 없는 행운권으로 변경
        }
        return tickets;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 행운권 수 N
        int m = sc.nextInt(); // 회원 수 M

        int[] idx = new int[m];

        for(int i = 0; i < m; i++){
            idx[i] = sc.nextInt(); // 회원번호 입력
        }

        ArrayList<Integer> tickets = getTicketNumbers(n, m, idx);

        for(int ticket : tickets){
            System.out.println(ticket);
        }
    }
}