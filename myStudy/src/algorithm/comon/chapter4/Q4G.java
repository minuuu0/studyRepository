package algorithm.comon.chapter4;

import java.util.Scanner;

public class Q4G {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(); // 배열의 크기 n
        int m = sc.nextInt(); // 처리할 명령어의 수 m

        ShiftingArray<Integer> array = new ShiftingArray<>(n);
        for(int i = 0; i < n; i++){
            array.set(i, sc.nextInt()); // 배열 데이터 입력
        }

        // 명령어 처리
        for(int i = 0; i < m; i++){
            int cmd = sc.nextInt(); // 명령어 정보 확인
            if(cmd == 0){
                // 현재 배열의 p번 인덱스를 출력하라
                int p = sc.nextInt();
                int value = array.get(p);
                System.out.println(value);
            } else if (cmd == 1) {
                // 현재 배열을 k번 왼쪽으로 이동
                int k = sc.nextInt();
                array.shiftLeft(k);
            } else if (cmd == 2) {
                // 현재 배열을 k번 오른쪽으로 이동
                int k = sc.nextInt();
                array.shiftRight(k);
            }else if (cmd == 3){
                // 현재 배열을 최초의 위치로 복원
                array.initializePosition();
            }

        }
    }
}
class ShiftingArray<T>{
    private final T[] array; // 내부에 데이터를 저장할 배열
    public final int length; // 배열의 길이

    private int leftIndex; // 가장 왼쪽에 있는 원소의 원본 배열의 인덱스

    public ShiftingArray(int length){
        this.length = length;
        this.array = (T[]) (new Object[length]);
        this.leftIndex = 0;
    }

    public void shiftLeft(int times){
        // 배열을 왼쪽으로 이동하는 것은
        // 배열의 시작점이 오른쪽으로 이동하는 것과 같다
        times = times % length; // 인덱스 초과를 맞기위한 나머지연산
        leftIndex = (leftIndex + times) % length;
    }
    public void shiftRight(int times){
        // 배열 오른쪽 이동은 배열의 시작점이 왼쪽으로 이동하는 것과 같다
        times = times % length;
        leftIndex = (leftIndex - times + length) % length;
    }

    public T get(int index){
        int realIndex = (index + leftIndex) % length;
        return array[realIndex];
    }

    // 현재 배열에서 index위치의 원소를 value로 변경하는 함수
    public void set(int index, T value){
        int realIndex = (index + leftIndex) % length;
        array[realIndex] = value;
    }

    // 현재 배열의 모든 원소를 초기로 변환하기
    public void initializePosition(){
        leftIndex = 0;
    }
}