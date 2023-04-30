package algorithm.baekjoon.foundation.datastructure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E>{

    private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기
    private static final Object[] EMPTY_ARRAY = {}; // 빈 배열

    private Object[] array; // 요소를 담을 배열
    private int size; // 요소 개수

    public Stack(){
        this.array = EMPTY_ARRAY; // 빈 배열 할당
        this.size = 0; // 크기는 0
    }

    public Stack(int capacity){
        this.array = new Object[capacity]; // 해당 타입의 배열 할당
        this.size = 0;
    }

    private void resize(){ // 배열 크기 조절함수
        // 빈 배열의 경우 (capacity is 0)
        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY]; // 10개 공간의 배열 할당
            return;
        }

        int arrayCapacity = array.length; // 현재 배열의 크기

        if(size == arrayCapacity){ // 사이즈가 가득 찬 경우
            int newSize = arrayCapacity * 2;

            array = Arrays.copyOf(array, newSize); // 배열 복사
            return;
        }

        if(size < (arrayCapacity / 2)){
            int newCapacity = arrayCapacity / 2;

            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity)); // 배열 복사
            return;
        }

    }

    @Override
    public E push(E item) {
        if(size == array.length){
            resize();
        }
        array[size] = item; // 마지막 위치에 원소 추가
        size++; // 사이즈 증가

        return item;
    }

    @Override
    public E pop() {
        if(size == 0) throw new EmptyStackException();

        E obj = (E) array[size - 1]; // 삭제할 요소 반환
        array[size - 1] = null;

        size--;
        resize(); // 크기 재할당
        return obj;

    }

    @Override
    public E peek() {
        if(size == 0) throw new EmptyStackException();
        return (E) array[size - 1];
    }

    @Override
    public int search(Object value) {
        // value값이 널인 경우
        if(value == null){ // value가 널일 경우 equals(null)이 되어 pointer exception 발생 가능
            for(int idx = size - 1; idx >= 0; idx--){ // 배열을 순회하며
                if(array[idx] == null){ // 배열에 널이 있다면
                    return size - idx; // 해당 원소 위치의 인덱스를 반환한다
                }
            }
        }else{ // value값이 널이 아닌 경우
            for(int idx = size -1; idx >= 0; idx--){
                if(array[idx].equals(value)){
                    return size -idx;
                }
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            array[i] = null; // 저장된 모든 요소 null 처리
        }
        size = 0;
        resize();
    }

    @Override
    public boolean empty() {
        return size == 0;
    }
}
