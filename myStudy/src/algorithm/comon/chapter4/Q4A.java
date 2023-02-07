package algorithm.comon.chapter4;

import java.util.Scanner;

public class Q4A {
    public static final Scanner sc = new Scanner(System.in);


    private static void testCase(int caseIndex) {
        int index = sc.nextInt(); // 칸의 번호 입력
        SudokuBoard board = new SudokuBoard(); // 스도쿠 객체 생성

        int row = board.getRowByIndex(index); // 행 계산
        int col = board.getColByIndex(index); // 열 계산
        int group = board.getGroupByPosition(row, col); // 그룹번호 계산하기

        // 정답을 출력한다
        System.out.printf("Case #%d:\n", caseIndex);
        System.out.printf("%d %d %d\n", row, col, group);
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt(); // 테스트케이스 입력

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}

class SudokuBoard{
    static final int MAX_ROW = 9;
    static final int MAX_COL = 9;

    // 칸의 번호로 행을 계산하는 인덱스
    public int getRowByIndex(int index){
        return (index - 1) / 9 + 1;
    }

    // 칸의 번호로 열을 계산하는 인덱스
    public int getColByIndex(int index){
        return (index - 1) % 9 + 1;
    }
    // 칸의 번호로 그룹 번호를 계산하는 인덱스
    public int getGroupByIndex(int index){
        int r = getRowByIndex(index);
        int c = getColByIndex(index);
        return getGroupByPosition(r, c);
    }
    // 칸의 위치로 그룹 번호를 계산하는 메소드
    public int getGroupByPosition(int row, int column) {
        int left = ((row - 1) / 3) * 3 + 1; // 행의 가장 왼쪽 그룹 번호(row행 , 1~3열)
        int offset = ((column - 1) / 3);  // 실제 이 열이 속한 그룹의 위치
        // 열마다 그룹번호를 할당하는데 행 + 열로 그룹번호를 주기에 행에서 1based를 이미 주었기 때문에 +1을 하지 않는다
        return left + offset;
    }

    // 문제와 예외로 구현해보기
    // 칸의 위치(행, 열)로 칸의 번호를 계산하는 메소드
    public int getIndexByPosition(int row, int column) {
        return ((row - 1) * 9) + column;
    }
}
