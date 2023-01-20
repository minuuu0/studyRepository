import java.util.Scanner;

public class Test {
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
        long count = 0;
        for(int x = 0; x <= R; x++){
            for(int y = 0; y <= R; y++){
                // <x, y> := (0, 0) ~ (R, R) 까지의 모든 좌표가 한번씩 나온다
                if(isInside(x, y, R)){
                    // <x, y>가 왼쪽 아래점인 픽셀들 중 원 내부에 있는 모든 픽셀
                    System.out.printf("[%d,%d]", x, y);
                    count++;
                }
            }
        }
        System.out.printf("#%d\n", caseIndex);
        System.out.println(count * 4);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}