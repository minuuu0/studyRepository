package algorithm.comon.chapter2;

import java.util.Scanner;

public class Q2H {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 왼쪽 아래 좌표가 (x,y)인 픽셀이 반지름 R인 원에 포함되는가?
     * @param x
     * @param y
     * @param R
     * @return  포함된다면 true, else false
     */
    public static boolean isInside(long x, long y, long R)
    {
        // 문제에서 주어진 반지름이 10만이기에 좌표가 10만 가까이 나올 수 있다
        // 이를 제곱하면 100억이 나온다 -> int는 21억의 범위이기에 long 사용
        long sqd = x * x + y * y; // 왼쪽 아래의 점과 원점(0, 0)사이의 거리
        return sqd < R*R;
    }

    public static void testCase(int caseIndex) {
        long R = scanner.nextLong();
        long sum = 0;
        long y = R;
        for(int x = 0; x <= R; x++){
            for( ; y >=0; y--){
                if(isInside(x, y, R)){
                    // y := x좌표에서 위에서부터 내려오다가 최초로 원에 포함되는 픽셀의 y좌표
                    long h = y + 1; // 지정한 부분의 높이
                    sum += h;
                    break;
                }
            }
        }
        System.out.printf("#%d\n", caseIndex);
        System.out.println(sum * 4);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}
