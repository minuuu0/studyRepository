package datastructure;

public class Stack {
    private int[] stk; // 스택용 배열
    private int capacity; // 스택 용량
    private int ptr; // 스택 포인터

    // 실행 시 예외 : 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){}
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){}
    }

    public Stack(int maxlen){ // 생성자
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity]; // 해당 용량의 스택 생성
        }catch (OutOfMemoryError e){ // 생성할 수 없음
            capacity = 0;
        }
    }

    // push
    public int push(int x) throws OverflowIntStackException{
        if (ptr >= capacity) // 스택이 가득차면
            throw new OverflowIntStackException();
        return stk[ptr++] = x; // x값을 stk에 넣고 포인터를 1 증가한다
    }

    // pop
    public int pop() throws EmptyIntStackException{
        if(ptr <= 0) // 스택이 비어있다면
            throw new EmptyIntStackException();
        return stk[--ptr]; // 스택의 꼭대기를 제거하고 그 값 반환
    }

    // peek
    public int peek() throws EmptyIntStackException{
        if(ptr <= 0) // 스택이 비어 있다면
            throw new EmptyIntStackException();
        return stk[ptr - 1]; // 스택이 비어있지 않다면 꼭대기 요소 값 반환
    }

    // clear : 스택의 모든 요소 삭제
    public void clear(){
        ptr = 0;
    }

}
