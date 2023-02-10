package datastructure.recursive;

import java.util.Scanner;

// 폭 22, 높이 8의 직사각형은
        // 폭 8인 정사각형 2개와 폭이 6인 직사각형 한개이다 (8 x 8) 2개, (8 x 6) 1개
        // 8 x 6크기의 직사각형을 다시 위와 같은 방식으로 분할 (6 x 6) 1개, (6 x 2) 1개
        // 6 x 2 크기를 다시 분할 (2 x 2) 3개 => 2가 최대 공약수
        // 두 값이 주어질 때 큰 값을 작은값으로 나눠 나누어 떨어지몀ㄴ 그중에 작은값이 최대공약수 -> 이를 재귀로 구현
public class Euclidean {
    // 큰 값을 작은값으로 나눠 나누어 떨어지면 그 중에 작은값이 최대공약수
    // 즉 나눴을 때 0이면 return
    private static int gcd(int x, int y) {
        if(y == 0){
            return x;
        }else{
            return gcd(y, x % y); // y값이 더 크다면 x,y를 서로 바꿔준다(나머지 이용)
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int x = sc.nextInt();
        System.out.print("정수 입력 : ");
        int y = sc.nextInt();

        System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
    }
}
