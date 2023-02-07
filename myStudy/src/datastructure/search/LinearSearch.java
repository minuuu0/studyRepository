package datastructure.search;

import java.util.Scanner;

// 선형 검색 구현
public class LinearSearch {
    private static int seqSearch(int[] x, int num, int search) {

        for(int i = 0; i < num; i++){
            if(x[i] == search){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int num = sc.nextInt(); // 요솟수 입력
        int[] x = new int[num];

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
