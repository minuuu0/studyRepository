import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bubble_Sort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 버블 정렬(Bubble sort) 좋은 알고리즘은 아니지만 이해하기 쉬운 알고리즘
        int n = Integer.parseInt(br.readLine()); // n = 입력 개수 6
        int[] arr = new int[n]; // 입력한 크기만큼의 배열 할당

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 5 2 6 3 1 4
        }

        // 버블 정렬은 왼쪽값과 오른쪽값을 비교해 서로 swap하는 형식의 정렬
        // 5 2 6 3 1 4 -> 5가 2보다크니 스왑 -> 2 5 6 3 1 4 -> 6은 3보다 크니 스왑-> 2 5 3 6 1 4 -> 6은 1보다 크니 스왑 -> 2 5 3 1 6 4 -> 6은 4보다 크니 스왑 -> 2 5 3 1 4 6
        // 2는 5보다 크니 멈추고 5는 3보다 크니 스왑 -> 2 3 5 1 4 6 -> 5는 1보다 크니 스왑 -> 2 3 1 5 4 6 -> 5는 4보다 크니 스왑 -> 2 3 1 4 5 6
        // 위와 같은 방식의 버블정렬 시간복잡도는 n개의 배열을 n-1의 아이템을 비교한다 = 배열의 크기가 6이면 5번 비교해야함
        // 이 비교를 n벉하고 또 최악의 경우 모든 아이템을 스왑해야함
        // 따라서 버블정렬의 시간복잡도는 O(n^2)

        for(int i = 0; i < n; i++) { // arr[0] ~ 5의 배열값 접근
            for(int j = 0; j < n - 1 - i; j++) { // 버블정렬을 하면 한사이클을 돌때마다 맨뒤는 무조건 가장 큰값이 들어가기에 마지막은 비교를 할필요가 없다
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int arrs : arr) {
            System.out.println(arrs);
        }

    }
}
