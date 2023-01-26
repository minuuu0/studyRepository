package algorithm.comon.chapter3;

import java.util.Scanner;

// 배열 원소 중 가장 많이 등장하는(최빈값)값을 찾아출력하라
// 같은경우 사전 순으로 번호를 출력, 출력 시 4자리 수로 출력(첫자리가 없으면 0123)
public class Q3A {
    public static final Scanner sc = new Scanner(System.in);
    public static final int MAX_TABLE_LENGTH = 10000;

    public static void fillFrequencyTable(int[] data, int n, int[] table) {
        for(int i = 0; i < n; i++){
            // data[i] = data에 저장된 모든 전화번호가 차례로 한번 씩 등장하는 변수
            table[data[i]]++; // table[num] := data배열에서 num이라는 정수가 들어간 횟수
        }
    }

    public static int getFrequentNumber(int[] data, int n) {
        int frequent_number = 0;  //0000~9999중  가장 많이 등장한 번호
        int[] table = new int[MAX_TABLE_LENGTH]; // 0~ 9999까지의 배열(인덱스로 활용한다)
        fillFrequencyTable(data, n, table);

        // table[number]가 가장 큰 number를 frequent_number에 저장하는 로직
        for(int number = 0; number < 10000; number++){
            int count = table[number];
            if(count > table[frequent_number]){
                frequent_number = number;
            }
        }
        return frequent_number;
    }
    public static void main(String[] args) {
        int n = sc.nextInt(); // 입력 수
        int[] data = new int[n]; // 최빈값 비교 데이터 배열 선언
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt(); // 비교 데이터 입력
        }

        int answer = getFrequentNumber(data, n);
        System.out.printf("%04d", answer);
    }
}
