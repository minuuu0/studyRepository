package algorithm.comon.chapter5;

import java.util.Scanner;
import java.util.Stack;

// 괄호 문자열
public class Q5A {
    static final Scanner sc = new Scanner(System.in);

    // 짝이 맞는지 판단하는 함수
    private static boolean isValidParentheses(int n, Parenthesis[] parentheses) {
        Stack<Parenthesis> stack = new Stack<>();

        for(Parenthesis p : parentheses){ // 모든 객체배열 p에 대해
            // 열린 상태라면 push
            if(p.type == Parenthesis.OPEN){
                stack.push(p);
            }else{
                // 닫힌 상태에서
                if(stack.size() > 0 && stack.peek().type == Parenthesis.OPEN){
                    // 짝 맞출 열린괄호가 있다면
                    stack.pop();
                }else{
                    // 짝 맞출 열린 괄호가 없다면
                    return false;
                }
            }
        }
        // 모든 닫힌 괄호는 소거했으나 열린게 남아있다면
        if(stack.size() > 0){
            return false;
        }

        return true;
    }

    // 테스트 케이스 함수
    private static void testCase(int caseIndex) {
        String input = sc.next();
        int n = input.length();

        Parenthesis[] parentheses = new Parenthesis[n]; // 입력 크기만큼 객체배열 생성

        for(int i = 0; i < n; i ++){
            parentheses[i] = new Parenthesis(i, input.charAt(i)); // 인덱스와 문자를 생성자로 초기화
        }

        boolean isValid = isValidParentheses(n, parentheses);

        if(isValid){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();
        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
class Parenthesis{
    public static final boolean OPEN = true;
    public static final boolean CLOSE = false;

    public final  boolean type;
    public final  int index;
    public Parenthesis(int index, boolean type){
        this.type = type;
        this.index = index;
    }
    public Parenthesis(int index, char c){ // 오버로딩
        this.index = index;
        if(c == '('){
            this.type = OPEN;
        }else{
            this.type = CLOSE;
        }
    }
}