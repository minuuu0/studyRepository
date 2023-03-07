package algorithm.comon.chapter5;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

// 정사각형
public class Q5I {
    static final Scanner sc = new Scanner(System.in);

    private static long getMaximumSquareArea(int n, Point2D[] points) {
        long answer = 0;

        // 모든 점을 set에 저장한다.
        TreeSet<Point2D> pSet = new TreeSet<>(); // orderedSet 자료구조
        for(int i = 0; i < n; i++){
            pSet.add(points[i]);
        }

        for(int i = 0; i < n; i++){
            Point2D pa = points[i];
            for(int j = 0; j < n; j++){
                Point2D pb = points[j];
                // 두 기준점 pa, pb를 지정
                // 선분 pa-pb가 정사각형의 한 변이라고 하자

                // 두 점 거리의 제곱은 정사각형의 넓이가 된다
                long area = pa.getSquaredDistanceTo(pb);

                // 이미 구한 사각형의 넓이가 작다면 건너뛴다.
                if(area < answer){
                    continue;
                }

                // pa -> pb방향의 x, y 좌표를 구한다.
                int dx = pb.x - pa.x;
                int dy = pb.y - pa.y;

                // 벡터 <dx, dy>를 90도로 회전시키면 <-dy, dx>가 된다.
                // pa와 pb를 벡터 <-dy, dx>를 각각 더해 정사각형을 구성하는 두 점 계산
                Point2D pd = new Point2D(pa.x - dy, pa.y + dx);
                Point2D pc = new Point2D(pb.x - dy, pb.y + dx);

                if(pSet.contains(pc) && pSet.contains(pd)){
                    answer = Math.max(answer, area);
                }

            }
        }
        return answer;
    }

    private static void testCase(int caseIndex) {
        int n = sc.nextInt(); // 점의 수

        Point2D[] points = new Point2D[n];

        for(int i = 0; i < n; i++){
            int x = sc.nextInt(); // 좌표의 x점
            int y = sc.nextInt(); // 좌표의 y점
            points[i] = new Point2D(i, x, y);
        }
        long answer = getMaximumSquareArea(n, points);
        System.out.printf("%.2f\n", (double) answer);
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
class Point2D implements Comparable<Point2D>{
    public final int x; // x점
    public final int y; // y점
    public final int index; // 인덱스 번호

    Point2D(int index, int x, int y){
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public Point2D(int x, int y){
        this(-1, x, y); // 생성자에서 생성자 호출
    }
    public long getSquaredDistanceTo(Point2D target){
        long dx = Math.abs(this.x - target.x);
        long dy = Math.abs(this.y - target.y);
        return dx * dx + dy * dy;
    }

    public double getDistanceto(Point2D target){
        // 두 좌표사이의 실수 거리 계산
        long sqd = this.getSquaredDistanceTo(target);
        return Math.sqrt(sqd);
    }

    @Override
    public int compareTo(Point2D o) {
        // 각 좌표의 우선순위를 비교하기 위한 비교연산자

        // x좌표가 다르다면 x좌표를 기준으로 비교
        if(this.x != o.x){
            return this.x - o.x;
        }

        // x좌표가 같다면 Y좌표 기준 비교
        return this.y - o.y;
    }
}