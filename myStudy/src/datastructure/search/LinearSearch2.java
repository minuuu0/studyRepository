package datastructure.search;

import java.util.Scanner;

public class LinearSearch2 {
    private static int seqSearch(int[] x, int num, int search) {
        int i = 0;
        x[num] = search; // 배열의 마지막값을 탐색할 값 적용

        while (true){
            if(x[i] == search){
                break;
            }
            i++;
        }
        return i == num ? -1 : i; // 탐색값이 배열의 크기와 같으면 -1, 아니면 i인덱스 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int num = sc.nextInt(); // 요솟수 입력
        int[] x = new int[num + 1]; // 보초법을 사용하기 위해 배열의 크기를 한칸 더 할당해준다

        for(int i = 0; i < x.length; i++){
            System.out.print("x[" + i + "]:");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값 : ");
        int search = sc.nextInt();

        int idx = seqSearch(x, num, search);

        if(idx == -1){
            System.out.println("요솟수가 없습니다.");
        }else {
            System.out.println(search +"값은 x[" + idx + "] 위치에 있습니다.");
        }
    }
}
