import java.util.ArrayList;
import java.util.Scanner;

public class Q5E {
    // 폭탄 제거
    static final Scanner sc = new Scanner(System.in);
    private static void testCase(int caseIndex) {
        int n = sc.nextInt(); // 폭탄 수
        int m = sc.nextInt(); // 연쇄 관계 수

        Bomb[] bombs = new Bomb[n];
        for(int i = 0; i < n; i++){
            bombs[i] = new Bomb(i); // 각 폭탄에 대한 초기화
        }

        for(int i = 0; i < m; i++){
            int u = sc.nextInt(); // u가 해제되면
            int v = sc.nextInt(); // v가 폭발한다

            Bomb b = bombs[v];
            b.addParentBombs(bombs[u]); // v에 u가 폭발을 유발할 수 있는 리스트임을 추가한다
        }

    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();
        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
class Bomb{
    private int index;
    private int childCount; // 이 폭탄이 터졌을 때 함께 폭발하는 폭탄 수
    private ArrayList<Bomb> parentBombs; // 이 폭탄의 폭발을 유발할 수 있는 폭탄 리스트
    Bomb(int index){
        this.index = index;
        this.childCount = 0;
        this.parentBombs = new ArrayList<>();
    }

    void addParentBombs(Bomb child){
        this.parentBombs.add(child);
        child.childCount++;
    }
}