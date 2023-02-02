import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q3I {
    static final Scanner sc = new Scanner(System.in);
    private static ArrayList<Integer> getPossibleTargetNumber(int n, int m, int[] cards, int[] target) {

        Arrays.sort(cards); // 이진 검색을 위한 정렬
        ArrayList<Integer> answers = new ArrayList<Integer>();

        for(int k : target){ // 모든 검사해야할 k에 대해

            boolean possible = false; // k를 세 숫자의 합으로 표현할 수 있는지

            for(int i = 0; i < n; i++){
                int x = cards[i];
                for(int j = 0; j <= i; j++){
                    int y = cards[j];
                    int z = k - (x + y); // z값을 구해 이진검색한다

                    if(Arrays.binarySearch(cards, z) >= 0){
                        possible = true;
                        break;
                    }
                }
                if(possible){
                    // 이미 찾았으면 탈출 (가지치기)
                    break;
                }
            }
            if(possible){
                answers.add(k);
            }
        }
        Collections.sort(answers);
        return answers;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 사용할 카드의 수 (1 ~ 1000)
        int m = sc.nextInt(); // 당첨번호의 수 (1 ~ 100)

        int[] cards = new int[n]; // 카드의 수를 담을 배열
        int[] target = new int[m]; // 당첨 번호의 수를 담을 배열

        for(int i = 0 ; i < n; i++){
            cards[i] = sc.nextInt(); // 카드 데이터 입력
        }
        for(int i = 0; i < m; i++){
            target[i] = sc.nextInt(); // 당첨 데이터 입력
        }

        ArrayList<Integer> answers = getPossibleTargetNumber(n, m, cards, target);

        if(answers.size() == 0){
            System.out.println("NO");
        }else{
            for(int i = 0; i < answers.size(); i++){
                if(i > 0){
                    System.out.print(" ");
                }
                System.out.print(answers.get(i));
            }
        }

    }
}
