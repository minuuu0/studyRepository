package algorithm.comon.chapter2;

// 2차원 평면 점사이의 거리 구하기 알고리즘
// 입력 형식
// 첫 줄에는 점의 수 N (2 <= N <= 1000)
// 그 후 N줄에 걸쳐 점의 좌표를 나타내는 두 정수가 주어진다(공백으로 구분) 모든 좌표는 절대값 1만이하, 좌표는 서로 다르다는 조건

import java.util.Scanner;

// 출력 형식
// 첫 줄에는 가장 가까운 두 점의 거리를 소수점 두번째 자리에서 반올림하여 첫번째 자리까지 출력
// 두 번째 줄에는 그 거리만큼 떨어진 점 쌍의 수를 출력
public class Q2F {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(); // 점의 수
        Point2D[] points = new Point2D[n]; // 객체 배열 생성
        for(int i = 0; i < n; i++){
            int x = sc.nextInt(); // 점의 x좌표 입력
            int y = sc.nextInt(); // 점의 y좌표 입력
            points[i] = new Point2D(x, y); // 객체 배열 값 추가
        }

        int minDist = Integer.MAX_VALUE; // 가장 짧은 거리
        int minCount = 0; // minDist만큼의 거리를 가진 점의 수
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){ // n = 2라면 1,0
                // 두 점의 제곱 계산 함수
                int sqd = points[i].getSquaredDistanceTo(points[j]); // 두 점사이 거리의 제곱
                if(sqd < minDist){ // 가장 짧은 거리보다 작다면
                    minDist = sqd; // 최소 거리 갱신
                    minCount = 1; // minDist와 같은 거리의 점 갱신(sqd라는 최소거리가 있기에 1로 갱신)
                }else if(sqd == minDist){
                    // 갱신하지 않아도 최소거리를 가지면
                    minCount++;
                }
            }
        }
        System.out.printf("%.1f\n", Math.sqrt(minDist));
        System.out.printf("%d", minCount);
    }
}
class Point2D{
    int x;
    int y;
    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    // 거리의 제곱을 구하는 함수
    public int getSquaredDistanceTo(Point2D target){
        int deltaX = this.x - target.x;
        int deltaY = this.y - target.y;
        return deltaX * deltaX + deltaY * deltaX;
    }
    // 거리 구하는 함수
    public double getDistanceTo(Point2D target){
        return Math.sqrt(getSquaredDistanceTo(target));
    }
}