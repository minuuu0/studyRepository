package algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    // x = 데이터담긴 배열, n = 데이터 수(배열 크기) , ky = 검색 값
    private static int binSearch(int[] x, int n, int ky) {
        int pl = 0; // 검색 범위의 첫 인덱스
        int pr = n - 1; // 검색 범위의 끝 인덱스

        do {
            int pc = (pl + pr) / 2; // pc = 중앙 요소의 인덱스

            if(x[pc] == ky){ // 중앙값이 검색값과 일치하면 = (검색이 성공한다면)
                return pc; // 중앙인덱스 반환
            }
            else if (x[pc] < ky){ // 검색 범위를 뒤쪽 절반으로 좁힌다
                pl = pc + 1;
            }else{
                pr = pc - 1; // 검색 범위를 앞쪽 절반으로 좁힘
            }
        }while (pl <= pr);

        return -1; // 검색 실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int n = sc.nextInt(); // n = 데이터 수
        int[] x = new int[n]; // n개의 배열 생성

        System.out.println("데이터 입력 : ");
        x[0] = sc.nextInt(); // 첫 요소 입력

        for(int i = 1; i < n; i++){
            x[i] = sc.nextInt(); // 나머지 요소 입력
        }
        Arrays.sort(x); // 배열 값 정렬

        System.out.print("검색 값 : ");
        int ky = sc.nextInt(); // ky = 검색값

        int idx = binSearch(x, n, ky); // 이진 검색 함수 호출

        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다");
        }else{
            System.out.println("그 값은 " + idx +"번째에 있습니다");
        }

    }
}
