package algorithm.comon.chapter3;

import java.util.Scanner;

public class Q3B {
    private static void solve(int n, int m, Paint[] paint) {
        int[] seats = new int[n]; // 실제 색상 적용 배열 생성


        for(Paint p : paint){ // paint 객체 배열에는 색칠 방법이 들어있다
            for(int i = p.left; i <= p.right; i++){ // 이를 적용해준다
                seats[i] = p.color;
            }
        }

        // seats[]에 현재 색상값들이 들어가 있는데 우린 여기서 가장 많고 적은 색상을 도출해야한다
        // 빈도 수 배열을 만들어 이 배열을 통해 풀어보자
        int[] table = new int[100]; // table[c] := 색상 c가 seats내에서 몇개 있는지 (입력값은 0 ~ 99개로 제한)
        for(int i = 0; i < n; i++){
            // seats[i] = 좌석에 색칠된 모든 색상
            table[seats[i]]++;
        }

        // 문제 조건 1. 한번도 등장하지 않은 색상은 초기화 x
        // 문제 조건 2. 같은 조건이면 색상 값이 번호가 작은얘 우선
        int minColor = -1;
        int maxColor = -1;
        for(int color = 0; color <= 99; color++){
            // color :=  0 ~ 99 사이 모든 색상
            if (table[color] == 0) continue; // 한번도 나오지 않은 색상은 건너뛴다
            if(minColor == -1 || table[color] < table[minColor]){
                minColor = color;
            }
            if(maxColor == -1 || table[color] > table[maxColor]){
                maxColor = color;
            }
        }

        System.out.println(maxColor);
        System.out.println(minColor);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 좌석의 수
        int m = sc.nextInt(); // 색칠할 방법 수

        Paint[] paint = new Paint[m]; // 좌석 수만큼 객체배열을 만든다

        for(int i = 0; i < m; i++){
            int left = sc.nextInt() - 1;  // 가장 왼쪽 번호 입력 (인덱스 기준에 맞추기 위해 -1)
            int right = sc.nextInt() - 1; // 가장 오른쪽 번호 입력 (인덱스 기준에 맞추기 위해 -1)
            int color = sc.nextInt(); // 색의 번호 입력
            paint[i] = new Paint(left, right, color);
        }
        solve(n, m, paint);
    }

    static class Paint{
        public int left;
        public int right;
        public int color;
        Paint(int left,int right,int color){
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
}
