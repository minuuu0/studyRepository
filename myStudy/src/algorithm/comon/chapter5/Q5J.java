package algorithm.comon.chapter5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class Q5J {
    public static final Scanner sc = new Scanner(System.in);
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(); // n개의 정수 입력

        // 각 <정수, 빈도수> 형태로 key-value를 저장할 Map 자료구조
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();

        for(int i = 0; i < n; i++){
            int x = sc.nextInt(); // 실제 데이터가 들어온다

            // 한번도 등장하지 않은 숫자라면
            if(frequencyMap.containsKey(x) == false){
                // 빈도수를 0으로 초기화
                frequencyMap.put(x, 0);
            }

            // 현재 frequencyMap에 저장된 적 있는 숫자의 개수 저장
            int c = frequencyMap.size();

            // x에 대한 빈도수를 갱신하여 저장
            int f = frequencyMap.get(x) + 1;
            frequencyMap.put(x, f);

            writer.write(String.format("%d %d\n", c, f));
        }

        // C F 형식으로 정수 출력
        // C : 현재까지 입력된 숫자의 종류의 수 ex) 1, 2, 2, 1, 3 -> 1, 2, 2, 2, 3 -> 자료구조에 있는지 확인하고 없으면 빈도수 증가
        // F : 이번에 입력된 숫자가 등장한 수 ex) 1, 2, 2, 1, 3 -> 1, 1, 2, 2, 1 -> 자료구조에 있는지 확인해서 있으면 빈도수 증가
        writer.flush();
        writer.close();
    }
}
