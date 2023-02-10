package datastructure;

// FIFO(First in FirstOut)

public class Queue {
    // front : 논리적인 맨 앞 요소의 인덱스
    // rear : 논리적인 맨 뒤 요소 하나 뒤의 인덱스(다음 요소를 인큐할 위치의 인덱스)
    // [35, 56, 24, 68, 95, 73, 19]가 차례대로 que[7] ~ que[11], que[0], que[1]에 저장
    // front : 7 rear : 2
    // [82]값을 인큐하면 que[2] (rear위치)에 82를 저장하고 rear값 1 증가
    // 35를 디큐하면 que[front]를 제거하고 front 값 1 증가

    private int[] que; // 큐용 배열
    private int capacity; // 큐의 용량
    private int front; // 맨 앞의 요소 커서
    private int rear; // 맨 뒤의 요소 커서
    private int num; // 현재 데이터 개수

    public Queue(int maxlen){ // 생성자
        num = front = rear = 0; // 초기화
        capacity = maxlen;
        que = new int [capacity]; // 생성자로 큐 배열 생성
    }

    // 인큐
    public int enque(int x){
        que[rear++] = x; // 인큐하면 rear위치에 x값을 저장하고 rear값을 1증가
        num++; // 데이터의 개수가 1증가한다
        if(rear == capacity){
            rear = 0; // 링버퍼 이용
        }
        return x;
    }

    public int deque(){
        int x = que[front++]; // x = 큐에서 front위치값을 가져오고 front를 1증가한다
        num--; // 디큐했기 때문에 데이터 1 감소
        if(front == capacity)
            front = 0; // 링버퍼
        return x;
    }

}
