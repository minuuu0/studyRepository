package algorithm.comon.chapter3;

import java.util.Scanner;

public class Q3G {
    public static final Scanner sc= new Scanner(System.in);

    public static int getUniqueRangeNumber(int[] birthDate, int n, int k)
    {
        int answer = 0; //모든 원소가 서로 다른 범위의 수

        // 모든 윈도우 중 모든 원소가 서로 다른 원소를 카운트
        // 모든 원소가 서로 다르다 => 모든 원소의 빈도수가 1 => 모든 원소가 유니크하다
        // 모든 원소가 유니크하다 => table.uniqueElements == 현재 원소의 개수
        // 5개의 원소가 table에 저장되어 있는데 uniqueElements == 5다? -> 모든 원소가 유니크하다

        // table.uniqueElements == k개인것을 아는 문제와 같다
        FrequencyTable table = new FrequencyTable(); // 930503 930503 890412 670610 680525
        // 첫 윈도우 탐색
        for(int i = 0; i < k; i++){
            table.addBirthDate(birthDate[i]); // 0~ 탐색할 k개 데이터를 table에 넣어준다
        }
        // 첫 윈도우갱신
        if(table.uniqueElements == k){
            answer++;
        }

        // 두번째부터 n까지 탐색
        for(int i = 1; i + k - 1 < n; i++){ // 930503 930503 890412 670610 680525
            // table을 i부터 i + k - 1 까지 갱신하고 전부다르면 ans+1
            table.removeBirthDate(birthDate[i-1]); // 이전 윈도우의 가장 왼쪽 삭제
            table.addBirthDate(birthDate[i + k - 1]); // 이번 윈도우의 새로운 원소 추가
            if(table.uniqueElements == k){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] birthDate = new int[n]; // 수열 배열에 저장한다
        for(int i = 0 ; i < n ; i ++)
        {
            birthDate[i] = sc.nextInt(); // 수열 데이터 입력
        }

        int answer = getUniqueRangeNumber(birthDate, n, k);

        System.out.println(answer);
    }

}

class FrequencyTable // 윈도우 표현 클래스
{
    public static final int MAX_SIZE = 1000000; // 생일의 크기는 6자리 즉 100만이하의 테이블에 각 빈도수를 찾는다

    int uniqueElements; //현재 중복이 존재하지 않는 unique한 생일의 수
    int[] frequency;    //frequency[b] := 생일이 b인 정보의 수 (빈도 수 테이블)

    FrequencyTable(){
        this.uniqueElements = 0;
        this.frequency = new int[MAX_SIZE];
    }

    /**
     * 새로운 생일을 등록하고 빈도수를 갱신한다.
     * @param birthDate
     */
    void addBirthDate(int birthDate)
    {
        int count = frequency[birthDate] ; // 매개변수 생일의 빈도 수를 카운트해
        if(count == 0){ // 존재하지않은 원소가 한개가 되었을 때
            this.uniqueElements++; // 유일한 값이 된다
        }else if(count == 1){ // 유일하던 원소가 두개가 되었을 때
            this.uniqueElements--; // 유일한 값이 아니게 된다
        }

        this.frequency[birthDate]++; // 빈도수 테이블을 + 1
    }

    /**
     * 기존의 생일을 제거하고 빈도수를 갱신한다.
     * @param birthDate
     */
    void removeBirthDate(int birthDate)
    {
        int count = frequency[birthDate]; // 빈도수를 받아와
        if(count == 1){ // 유일하던 원소가 제거되었을 때
            this.uniqueElements--; // 유일한 값이 아니게 되고
        }
        else if (count == 2){ // 두개가 존재한 원소가 하나가 되었을 때
            this.uniqueElements++; // 유일한값이 된다
        }

        this.frequency[birthDate]--;
    }

}