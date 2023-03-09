package algorithm.comon.chapter5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Q5K {
    static final Scanner sc = new Scanner(System.in);
    static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = sc.nextInt(); // 투표 수

        Map<String , Integer> frequencyMap = new HashMap<>();
        Set<String> winnersList = new TreeSet<>();// 사전 순 정렬을 위해 TreeSet

        int maxFrequency = 0; // 가장 많은 득표수

        for(int i = 0; i < n; i++){
            String name = sc.next();

            if(frequencyMap.containsKey(name) == false){
                // 이 이름이 등장한적 있다면 지나간다
                frequencyMap.put(name, 0);
            }

            // 빈도수 갱신
            int freq = frequencyMap.get(name) + 1;
            frequencyMap.put(name, freq);

            // 최대 빈도 계산
            if(freq > maxFrequency){
                maxFrequency = freq;
            }
        }
        // 최대 득표수 출력
        writer.write(String.format("%d\n", maxFrequency));

        // 최대 득표한 동점 후보들 이름을 사전순으로 출력
        for(String name : frequencyMap.keySet()){
            if(frequencyMap.get(name) == maxFrequency){ // 최대 득표자라면
                winnersList.add(name);
            }
        }

        // winnersList = 최다 득표를 한 동점자들(정렬 되어 있다)
        boolean first = true;
        for(String name : winnersList){
            writer.write(name+" ");
        }
        writer.flush();
        writer.close();
    }
}
