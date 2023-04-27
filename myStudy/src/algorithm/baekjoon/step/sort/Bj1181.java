package algorithm.baekjoon.step.sort;

import java.util.*;
public class Bj1181 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();

        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            hashSet.add(sc.next());
        }

        list.addAll(hashSet);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()){ // 길이가 같은 경우
                    return s1.compareTo(s2); // s1과 s2 비교해 틀린 개수 반환
                }
                return s1.length() - s2.length();
            }
        });
        for(String word : list){
            System.out.println(word);
        }

    }
}
