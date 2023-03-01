package algorithm.comon.chapter5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5D {
    static final Scanner sc = new Scanner(System.in);

    // n = 7 m = 3 -> 3, 6, 2, 7, 5, 1, 4
    private static ArrayList<Integer> getDeadPlayersList(int n, int m, int[] arr) {
        Queue<Integer> playerQueue = new LinkedList<>();
        ArrayList<Integer> deadPlayers = new ArrayList<>();

        for(int a : arr){
            playerQueue.add(a); // 배열 값 모두 큐에 추가
        }
        for(int i = 0; i < n; i++){
            int jump =  1 + (m - 1) % playerQueue.size(); // 1 based
            for(int k = 0; k < jump - 1; k++){
                int p = playerQueue.poll(); // 큐의 가장 앞 요소를 빼고
                playerQueue.add(p); // 다시 큐안에 넣는다
            }
            deadPlayers.add(playerQueue.poll());
        }
        return deadPlayers;

    }

    private static void testCase(int caseIndex) {
        int n = sc.nextInt(); // 사람의 수 n
        int m = sc.nextInt(); // 사람을 제외해 나갈 간격
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        ArrayList<Integer> deadPlayers = new ArrayList<>();

        deadPlayers = getDeadPlayersList(n, m, arr);

        System.out.println(deadPlayers);
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
