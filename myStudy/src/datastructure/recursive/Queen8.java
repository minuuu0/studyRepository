package datastructure.recursive;

public class Queen8 {
    // 서로 공격할 수 없는 8개의 퀸을 8x8 체스판에 놓자

    static boolean[] flag_a = new boolean[8]; // 각 행에 퀸을 이미 배치했는지 체크
    static boolean[] flag_b = new boolean[15]; // / 대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15]; // \ 대각성 방향으로 퀸을 배치했는지 체크
    static int[]pos = new int[8]; // 각 열에 있는 퀸의 위치

    // 각 열에 있는 퀸의 위치 출력
    private static void print() {
        for(int i = 0; i < 8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }
    private static void set(int i) { // i열에 퀸을 배치
        for(int j = 0; j < 8; j++){
            if(flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + 7] == false){
                pos[i] = j;
                if(i == 7)
                    print();
                else{
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0); // 0열에 퀸을 배치
    }
}
