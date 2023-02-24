package algorithm.comon.chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Q5B {
    static final Scanner sc = new Scanner(System.in);
    private static void findTargetTowers(int n, Tower[] towers) { // 6 3 4
        Stack<Tower> touchableTowers = new Stack<>();
        // 높이를 비교해서 높이가 작으면 pop()
        Tower target = null;
        // 모든 타워에 대해서
        for(Tower t : towers){
            while (touchableTowers.size() > 0 && touchableTowers.peek().height < t.height){
                touchableTowers.pop();
            }
            if(touchableTowers.size() > 0){
                target = touchableTowers.peek();
            }
            t.setTargetTower(target); // 수신 타겟 설정
            touchableTowers.push(t); // 스택에 값을 추가한다.
        }

    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        Tower[] towers = new Tower[n]; // n개의 객체 배열 생성
        for(int i = 0; i < n; i++){
            towers[i] = new Tower(i + 1, sc.nextInt());
        }

        // 각 타워 송신 레이저 타겟 모두 계산
        findTargetTowers(n, towers);

        for(int i = 0; i < n; i++){
            if(i > 0){
                System.out.printf(" ");
            }
            Tower t = towers[i];
            if(t.getTargetTower() == null){
                System.out.printf("0");
            }else{
                int targetIndex = t.getTargetTower().index;
                System.out.printf("%d", targetIndex);
            }

        }

    }
}
class Tower{
    int index;
    int height;

    private Tower targetTower; // 이 타워의 레이저를 수신하는 대상 타워
    Tower(int index, int height){
        this.index = index;
        this.height = height;
        this.targetTower = null;
    }
    public void setTargetTower(Tower targetTower){ // 객체를 입력받아서
        this.targetTower = targetTower; // 타겟타워 변수에 저장
    }
    public Tower getTargetTower(){
        return targetTower;
    }
}
