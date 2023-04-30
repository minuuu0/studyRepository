package algorithm.baekjoon.foundation.datastructure;

public interface StackInterface<E> { // E라는 제네릭 타입을 사용해 Stack에 추가되거나 가져올 데이터 타입 지정

    E push(E item); // 스택의 맨 뒤에 원소 추가

    E pop(); // 스택의 최상단 원소 제거

    E peek(); // 스택의 최상단 원소 반환

    int search(Object value); // 스택의 원소 찾기

    int size(); // 스택의 크기

    void clear(); // 스택의 모든 요소 제거

    boolean empty(); // 스택의 요소가 비어있는지 확인

}
