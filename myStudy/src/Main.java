import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 반지름이 R 픽셀인 원이 포함하는 픽셀 수를 계산해보자
// 탐색 범위는 R * R
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int test_Case = Integer.parseInt(br.readLine());
        int count = 0;
        for(int caseIndex = 1; caseIndex <= test_Case; caseIndex++){
            int R = Integer.parseInt(br.readLine());
            for(int x = 0; x <= R; x++){
                for(int y = 0; y <= R; y++){
                    // <x, y> := (0, 0) ~ (R, R) 까지의 모든 좌표가 한번씩 나온다
                    if(isInside(x, y, R)){
                        // <x, y>가 왼쪽 아래점인 픽셀들 중 원 내부에 있는 모든 픽셀
                        System.out.printf("[%d,%d]", x, y);
                        //[0,0][0,1][0,2][0,3][0,4][1,0][1,1][1,2][1,3][1,4][2,0][2,1][2,2][2,3][2,4][3,0][3,1][3,2][3,3][4,0][4,1][4,2]#1
                        count++;
                    }
                }
            }
            System.out.printf("#%d\n", caseIndex);
            System.out.println(count * 4);
        }
    }

    private static boolean isInside(int x, int y, int R) {
        long sqd = x * x + y * y; // 원점과 (x,y)의 거리
        return sqd < R * R;
    }
}
