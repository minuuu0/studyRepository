package algorithm.comon.chapter3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

// 빈도수를 이용한 중복제거 풀이 방법
public class Q3C_1 {
    public static final Scanner sc = new Scanner(System.in);
    public static final int MAX_N = 100000;
    private static ArrayList<Integer> getUniqueElements(int[] data, int n) {
        ArrayList<Integer> ret = new ArrayList<>();
        int[] table = new int[MAX_N + 1];

        // 빈도수 테이블 값 추가 O(n)
        for(int i = 0; i < n; i++){
            table[data[i]]++;
        }

        // 중복이 없다 = 빈도수 = 1이다 이용
        // O(100000) 의 시간복잡도
        for(int number = 1; number <= MAX_N; number++){ // 데이터는 1이상이므로 1부터 순회한다
            // 1 ~ 10만까지 순서대로 순회(오름차순)으로 순회하기에 데이터도 오름차순으로 삽입되어 정렬할 필요가 없다
            if(table[number] == 1){
                ret.add(number);
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // n개의 번호를 차례로 입력
        int n = sc.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i ++){
            data[i] = sc.nextInt();
        }

        // 중복 없는 원소 계산
        ArrayList<Integer> answers = getUniqueElements(data, n);

        // ArrayList 원소들 출력
        for(int i = 0; i < answers.size(); i++){
            int element = answers.get(i);
            if(i > 0){ // 첫 번째 원소가 아니라면 앞에 공백을 추가한다
                writer.write(" ");
            }
            writer.write(String.valueOf(element));
        }

        // BufferedWriter를 비우고 해제
        writer.flush();
        writer.close();

    }
}
