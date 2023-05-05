package algorithm.baekjoon.foundation.datastructure;

public class Queue E{
    // 큐 구현하기
    private static final int DEFAULT_CAPACITY = 64; // 최소(기본) 용적 크기

    private Object array[];
    private int size; // 요소의 개수

    // 첫 인덱스는 비워둔다 (빈 공간으로 비워두는 이유는 요소가 제거될 때마다 앞으로 한칸 씩 이동해야 하는데 이는 연산의 비용)
    // 즉 맨 앞 인덱스를 비워둠으로써 요소 제거시 front값을 이용해 맨 앞 요소 참조
    private int front; // 시작 인덱스를 가리킴
    private int rear; // 마지막 요소 포인터

    public Queue(){
        this.array = new Object[DEFAULT_CAPACITY]; // 64의 배열 크기 할당
        this.size = 0; // 요소는 0
        this.front = 0;
        this.rear = 0; // 모든 요소는 0
    }

    public Queue(int capacity){
        this.array = new Object[capacity]; // capacity만큼 값 할당
        this.size = 0; // 요소는 0
        this.front = 0;
        this.rear = 0; // 모든 요소는 0
    }

    // 동적할당을 위한 resize 구현
    // 용적이 가득찬다 = rear + 1이 front이다.

    private void resize(int newCapacity){
        Object[] newArray = new Object[newCapacity]; // 용적을 변경한 배열

        for(int i = 1, j = front + 1; i <= size; i++,j++){
            newArray[i] = array[j] % array.length; // front가 rear보다 작은 경우를 고려하기 위함
        }
        this.array = null;
        this.array = newArray; // 새 배열을 기존의 array로 덮어씌움

        front = 0;
        rear = size;
    }

    private boolean offer(E item){

        // 용적이 가득 찼을 경우
        if((rear + 1) % array.length == front){
            resize(array.length * 2); // 용량을 두배 늘려준다
        }

        rear = (rear + 1) % array.length; // rear을 다음 rear로 갱신

        array[rear] = item;
        size++; // 사이즈 1 증가
        return true;
    }

    public E poll(){ // 큐 원소 제거

        if(size == 0){
            return null;
        }

        front = front + 1 % array.length; // front를 한 칸 옮긴다(제거되니)

        E item = (E) array[front]; // 반환 데이터 저장
        array[front] = null; // 해당 front 삭제
        size--;

        // 용적이 64보다 크고 요소 개수가 1/4 미만일 경우 최적화 실시
        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)){

            // 아무리 작아도 기본 용적은 유지
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
        return item;
    }
    public E peek(){ // 큐 원소 조회
        if(size == 0){
            return null;
        }

        E item = array[(front + 1) % array.length];
        return item;
    }

}
