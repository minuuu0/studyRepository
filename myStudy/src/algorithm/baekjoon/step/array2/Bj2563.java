package algorithm.baekjoon.step.array2;

import java.util.Scanner;

public class Bj2563 {
    // 색종이의 넓이를 구하라 -> 겹치는 것 고려
    // 100 x 100 크기의 빈도수 테이블을 만들어 빈도수를 체크해서 1이상이라면 카운팅을 해주자
    // 왼쪽 아래의 정사각형 점이 주어지는데 이는 정사각형의 특성을 이용하면 쉽게 구할 수 있다
    static final Scanner sc = new Scanner(System.in);
    private static int getArea(Paper[] papers, int n) {

        int answer = 0; // 정사각형의 넓이
        int[][] board = new int[101][101]; // 100 x 100의 도화지(빈도 체크)

        for (Paper p : papers){
            for(int row = p.y; row <= p.topY; row++){ // 행번호
                for(int col = p.x; col <= p.rightX; col++){ // 열번호
                    board[row][col]++;
                }
            }
        }

        for(int i = 1; i < 101; i++){
            for(int j = 1; j < 101; j++){
                if(board[i][j] >= 1) answer++;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 색종이의 개수
        Paper[] papers = new Paper[n];

        for(int i = 0; i < n; i++){
            int x = sc.nextInt(); // 왼쪽 아래 점의 x좌표
            int y = sc.nextInt(); // 왼쪽 아래 점의 y좌표
            papers[i] = new Paper(x, y);
        }
        int answer = getArea(papers, n);
        System.out.println(answer);
    }
}
class Paper{
    public int x; // 왼쪽 아래 점의 x좌표
    public int y; // 왼쪽 아래 점의 y좌표
    public int rightX; // 오른쪽 아래 점의 x좌표
    public int topY; // 왼쪽 위의 점의 y좌표
    public Paper(int x, int y){
        this.x = x;
        this.y = y;
        this.rightX = x + 9; // 길이 고려기에 +9
        this.topY = y + 9;
    }
}
