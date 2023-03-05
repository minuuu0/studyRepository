import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5E {
    // 폭탄 제거
    static final Scanner sc = new Scanner(System.in);
    private static boolean isAllRemovable(int n, Bomb[] bombs) {

        // 제거해도 상관없는 폭탄
        Queue<Bomb> removableBombs = new LinkedList<>();

        // 제거 완료된 폭탄
        ArrayList<Bomb> removedList = new ArrayList<>();

        for (Bomb b : bombs){ // 모든 폭탄에 대해
            if(b.getChildCount() == 0){
                removableBombs.add(b);
            }
        }

        while (removableBombs.size() > 0){
            Bomb b = removableBombs.poll(); // 제거 가능 폭탄을 꺼낸다
            b.remove(); // 제거 가능한 폭탄을 제거 (Parent Bomb의 카운트를 1감소)
            removedList.add(b); // 제거 완료 리스트에 추가

            for(Bomb p : b.getParentBombs()){ // 제거 가능폭탄의 ParentBomb를 가져와
                if(p.getChildCount() == 0){
                    // 그 값이 0이면 제거 가능한 값이 된다
                    removableBombs.add(p);
                }
            }
        }
        if(removedList.size() == n){ // 제거한 개수가 폭탄수와 같으면 true
            return true;
        }else {
            return false;
        }

    }

    private static void testCase(int caseIndex) {
        int n = sc.nextInt(); // 폭탄 수
        int m = sc.nextInt(); // 연쇄 관계 수

        Bomb[] bombs = new Bomb[n];
        for(int i = 0; i < n; i++){
            bombs[i] = new Bomb(i); // 각 폭탄에 대한 초기화
        }

        for(int i = 0; i < m; i++){
            int u = sc.nextInt() - 1; // u가 해제되면
            int v = sc.nextInt() - 1; // v가 폭발한다

            Bomb b = bombs[v];
            b.addParentBombs(bombs[u]); // v에 u가 폭발을 유발할 수 있는 리스트임을 추가한다
        }
        boolean removable = isAllRemovable(n, bombs);

        if(removable) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
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

    int getChildCount(){
        return childCount;
    }


    public void remove() {
        // 해당 폭탄을 제거한다
        for(int i = 0; i < parentBombs.size(); i++){
            Bomb p = parentBombs.get(i);
            p.childCount -= 1;
        }
    }

    public ArrayList<Bomb> getParentBombs() {
        return parentBombs;
    }
}