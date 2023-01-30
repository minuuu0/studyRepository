package algorithm.comon.chapter3;

import java.util.Scanner;

public class Q3E {
        public static final Scanner sc = new Scanner(System.in);

        public static int getCoveredArea(Paper[] papers, int n){ // n: 색종이의 수, papers : 색종이 정보를 담은 객체배열

            int answer = 0; // 색종이들이 덮은 영역의 총 넓이
            int[][] board = new int[101][101]; // 도화지의 영역 설정

            for(Paper p : papers){ // 모든 색종이 p에 대해
                for(int row = p.bottomRow; row <= p.topRow; row++){
                    // row := 색종이 p가 담고있는 모든 행번호
                    for(int col = p.leftColumn; col <= p.rightColumn; col++){
                        // col := 색종이 p가 담고있는 모든 열번호
                        // <row, col> := 색종이 p가 담고 있는 모든 칸의 좌표
                        board[row][col]++;
                    }
                }
            }

            for(int row = 0; row <= 100; row++){
                for(int col = 0; col <= 100; col++){
                    // row, col := 도화지상의 모든 x, y 좌표
                    if(board[row][col] >= 1){
                        // row.col := 하나 이상의 색종이가 덮고있는 모든 칸
                        answer++;
                    }
                }
            }

            return answer;
        }
    public static void main(String[] args) {
            int caseSize = sc.nextInt(); // 테스트케이스 수 입력

            for(int i = 0; i < caseSize; i++){
                int n = sc.nextInt(); // 색종이의 수 입력
                Paper[] papers = new Paper[n]; // 색종이 정보를 담을 객체배열 생성
                for(int j = 0; j < n; j++){
                    int leftX = sc.nextInt();
                    int bottomY = sc.nextInt();
                    papers[j] = new Paper(leftX, bottomY);
                }

                //색종이들이 덮은 영역의 넓이를 계산한다
                int answer = getCoveredArea(papers, n);

                System.out.println(answer);
            }

    }
}
class Paper{
    int leftColumn; // 가장 왼쪽 격자의 열번호
    int rightColumn; // 가장 오른쪽 자리의 열번호
    int topRow; // 가장 위쪽 격자의 행번호
    int bottomRow; // 가장 아래쪽 격자의 행 번호
    Paper(int xPos, int yPos){ // 색종이의 왼쪽 아래 점을 생성자로 받는다 (1, 2)
        this.leftColumn = xPos;
        this.rightColumn = this.leftColumn + 9;
        this.bottomRow = yPos;
        this.topRow = yPos + 9;
    }
}
