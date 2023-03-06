package algorithm.comon.chapter5;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q5G {
    public static final Scanner sc = new Scanner(System.in);

    private static int getMaximumRangeDifference(int n, int k, City[] cities) {
        int answer = 0;

        // 소득이 가장 작은 도시부터 POP되는 우선순위 큐
        PriorityQueue<City> rangeMinimum = new PriorityQueue<>();

        // 소득이 가장 큰 도시부터 POP되는 우선순위 큐
        PriorityQueue<City> rangeMaximum = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 뒤집기

        // 슬라이딩 윈도우
        for(int i = 0; i < n; i++){
            City c = cities[i];

            int rightEnd = i; // 윈도우의 마지막 원소 i
            int leftEnd = i - k + 1;  // 윈도우의 첫 원소

            rangeMaximum.add(c); // 큐에 값 추가
            rangeMinimum.add(c); // 큐에 값 추가

            // 윈도우를 벗어난 원소 삭제 -> MIN, MAX에 영향을 주는 원소만 삭제
            // 큐가 비어있지 않고, 큐의 최대값 인덱스가 윈도우 밖이라면
            // 10 2 5 3 7 9 1
            while (rangeMaximum.size() > 0 && rangeMaximum.peek().index < leftEnd) {
                rangeMaximum.poll();
            }
            while (rangeMinimum.size() > 0 && rangeMinimum.peek().index < leftEnd){
                rangeMinimum.poll();
            }
            // rangeMaximum과 rangeMinimum에는 결과에 영향을 주는 윈도우 밖의 결과는 삭제됨 \
            if(leftEnd < 0){
                continue; // 윈도우가 음수인덱스라면 건너뛴다
            }
            int maximum = rangeMaximum.peek().income;
            int minimum = rangeMinimum.peek().income;
            int diff = maximum - minimum;
            answer = Math.max(answer, diff);
        }
        return answer;
    }

    private static void testCase(int caseIndex) {
        int n = sc.nextInt(); // 도시의 수 n
        int k = sc.nextInt(); // 조사의 영역 k (윈도우 범위)

        City[] cities = new City[n];

        for(int i = 0; i < n; i++){
            int income = sc.nextInt();
            cities[i] = new City(i, income);
        }
        int answer = getMaximumRangeDifference(n, k, cities);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
class City implements Comparable<City>{
    public final int index; // 해당 도시의 인덱스
    public final int income; // 해당 도시의 소득
    City(int index, int income){
        this.index = index;
        this.income = income;
    }
    @Override
    public int compareTo(City o) {
        // 소득에 대한 우선순위를 가지도록 대소관계 정의
        return this.income - o.income;
    }
}
