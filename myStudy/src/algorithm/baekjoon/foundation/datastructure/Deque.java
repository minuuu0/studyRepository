package algorithm.baekjoon.foundation.datastructure;

import java.util.Queue;

public class Deque<E>{

    private static final int DEFAULT_CAPACITY = 64; // 최소 용적 크기

    private Object[] array; // 요소를 담을 배열
    private int size; // 요소 개수
    private int front; // 시작 인덱스를 가리킴
    private int rear; // 마지막 인덱스를 가리킴

    public Deque(){ // 생성자
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public Deque(int capacity){ // 크기 지정한 경우
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity){
        int arrayCapacity = array.length; // 현재 용적 크기

        Object[] newArray = new Object[newCapacity]; // 용적 변경할 배열

        // 기존 원소의 배열이 r, s, t, u, NULL, o, p, t 의 경우 front = 5, rear = 4

        for(int i = 1, j = front+1; i <= size; i++, j++){ // 맨 앞 원소는 비운다.
            // front + 1 ~ rear까지 배열 복사
            newArray[i] = array[j % arrayCapacity]; // 원소 복사
        }
        this.array = newArray; // 기본 배열로 덮어씌움

        front = 0; // front와 rear을 재 설정 해준다.
        rear = size;

    }

    // 원소를 덱 뒤에 넣는 경우

    public boolean offer(E item) {
        // 용적이 가득 찼을 경우 -> rear이 front 앞에 있을 때
        if((rear + 1) % array.length == front){
            resize(array.length * 2);
        }

        rear = (rear + 1) % array.length; // rear 값 1 증가

        array[rear] = item;
        size++;

        return true;

    }
    // 원소를 덱 앞에서 넣는 경우
    public boolean offerFirst(E item) {
        // 용적이 가득 찼을 경우
        if((front - 1 + array.length) % array.length == rear){ // 음수 처리를 위해 array.length를 더함
            resize(array.length * 2);
        }

        front = (front -1 + array.length) % array.length;
        array[front] = item;
        size++;
        return true;

    }

    // 덱의 앞 요소 반환하기
    public E poll() {
        if(size == 0){
            return null;
        }

        front = front + 1 % array.length; // front를 이용해 앞의 원소 할당
        E item = (E)array[front]; // 배열에서 꺼내서
        array[front] = null; // 값을 비운뒤
        size--;

        // 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {

            // 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다.
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

    // 덱의 뒷 요소 제거하기
    public E pollLast() {
        if(size == 0){
            return null;
        }

        rear = (rear - 1 + array.length) % array.length;

        E item = (E)array[rear];
        array[rear] = null; // 값을 비운뒤
        size--;

        // 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {

            // 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다.
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item; // 해당 원소를 반환한다.
    }


}
