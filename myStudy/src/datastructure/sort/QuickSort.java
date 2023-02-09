package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    private static  void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1); // 배열의 시작위치와 끝 위치로 재귀함수를 호출
    }
    private  static  void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr, start, end); // 나눈 영역의 첫값을 받아온다
        if(start < part2 - 1){ // 오른쪽 파티션이 시작점 다음에서 시작한다면 왼쪽 파티션은 정렬할 필요가 없다 ex 2pivot [1 2!! 3 4 5]
            quickSort(arr, start, part2 - 1);
        }
        if(part2 < end){ // 오른쪽 파티션의 배열방이 한개 이상일때만 호출(오른쪽 파티션의 시작점이 마지막 배열방보다 작은경우)
            quickSort(arr, part2, end);
        }
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start + end) / 2]; // pivot은 중간값으로 지정
        while(start <= end){ // 시작점이 끝지점보다 작을때까지
            while(arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if(start <= end){ // 시작점과 끝점이 마주치지 않았는지 확인
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return  start;
    }

    private static void swap(int[] arr, int start, int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) throws IOException {
        // 퀵 정렬
        // 1. 기준값을 잡는다(pivot)
        // 2. 기준값을 기준으로 더 큰값영역과 작은값 영역 두 영역으로 나눈다
        // arr[3 7 8 1 5 9 6 10 2 4] - pivot: 3 (첫 값)
        // 기준값을 기준으로 왼쪽에서 오른쪽에서, 또 오른쪽에서 왼쪽으로 이동
        // 왼쪽에서 오른쪽으로 이동할 때는 기준값보다 큰값을 선택, -> 1. 7이 3보다 크니 7선택
        // 오른쪽 -> 왼쪽에선 기준값보다 작은값을 선택 -> 2. 4가 3보다 크니 선택x, 2가 3보다 작으니 2선택
        // 3. 선택된 두 값의 위치를 서로 바꾼다 -> 2와 7의 위치 변경 -> arr[3 2 8 1 5 9 6 10 7 4] -> 위 과정 반복
        // 3보다 큰 8 선택, 3보다 작은 1선택 -> arr[3, 2, 1, 8, 5, 9, 6, 10, 7, 4]
        // 근데 위를 정렬하려하니 왼쪽에서 오른쪽으로 이동할 땐 8이 선택되는데 오른쪽에서 왼쪽으로 이동할땐 1이다
        // 즉 작은 값의 인덱스가 큰 값의 인덱스보다 더 작아졌다(엇갈렸다) 이때는 작은값(1)을 pivot값과 바꿔준다 
        // arr[1 2 3 8 5 9 6 10 7 4] -> 엇갈리게 되면 3을 기준으로 3보다 왼쪽은 다 3보다 작고 오른쪽은 다 3보다 크다(1차분할)
        // 3을 기준으로 분할된 왼쪽집합 [1, 2]은 pivot보다 작고, 오른쪽집합[8 5 9 6 10 7 4]은 pivot보다 크다
        // 그렇다면 왼쪽집합에선 1이 pivot, 오른쪽집합에선 8이 pivot이 된다
        // 왼쪽집합부터 보면 [1 2]는 또 기준값1에서 엇갈리기에 1을 자기자신으로 바꾸고 그 안에서 또 분할한다[1 2 3 8 5 9 6 10 7 4]
        // 그후 오른쪽 집합을 보면 8보다 큰값인 9와 8보다 작은값인 4의 위치를 바꾼다 [1 2 3 8 5 4 6 10 7 9]
        // -> 10과 7을 바꾼다 [1 2 3 8 5 4 6 7 10 9]
        // -> 10과 7이 엇갈리기에 7과 8의 위치를 바꾼다 [1 2 3 7 5 4 6 8 10 9] -> 왼쪽집합 7 5 4 6, 오른쪽 집합 10 9
        // 왼쪽집합부터 보면 7이 pivot인데 7보다 큰값이 없기에 작은건 6이 골라지고 엇갈렷기에 6 과 7을 바꿔준다 [6 5 4 7] pivot : 6
        // 6보다 큰값 7 -> 7보다 작은 4 -> 엇갈렸기에 4와 6 위치 변경 [4 5 6 7] pivot : 4
        // 4보다 작은값 없기에 4는 자기 스스로 바꾸고 [5 6 7] -> 5도 마찬가지 -> [6 7] -> 6도 마찬가지...
        // 즉 이와 같이 [1 2 3 4 5 6 7 8 9 10]으로 정렬이 된다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n = 배열의 크기(정렬할 데이터 수)
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr);
        for(int a : arr){
            System.out.println(a);
        }
    }
}
