package algorithm.baekjoon.foundation.datastructure;


import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class Bj1406 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        // 1. LinkedList를 사용했으나 시간초과로 실패
//        LinkedList<Character> list = new LinkedList<>();
//
//        String str = br.readLine();
//        for(int i = 0; i < str.length(); i++){
//            list.add(str.charAt(i));
//        }
//        int pointer = list.size(); // 커서의 위치 0 : 가장 왼쪽 / list.size : 가장 오른쪽
//        int n = Integer.parseInt(br.readLine()); // 명령의 개수
//
//        for(int j = 0; j < n; j++){
//            String cmd = br.readLine(); // 명령어 입력
//            char c = cmd.charAt(0);
//            if(c == 'L'){ // 왼쪽으로 1칸이다 커서가 가장 왼쪽의 경우에는 가지 않으니 크기 조절
//                if(pointer > 0){
//                    pointer--;
//                }
//            } else if (c == 'D') {
//                if(pointer < list.size()){ // 포인터 크기 조절
//                    pointer++;
//                }
//            } else if (c == 'B') {
//                if(pointer > 0){ // 포인터의 크기가 1이상일때만
//                    list.remove(pointer - 1);
//                    pointer--;
//                }
//            }else{ // 삽입의 경우
//                char s = cmd.charAt(2); // 삽입할 문자를 꺼내
//                list.add(pointer, s);
//                pointer++; // 삽입 시 포인터도 늘려준다
//            }
//        }
//        for(char c : list)
//        {
//            bw.write(c);
//        }
//        bw.flush();
//        bw.close();

        // 2. 스택을 이용해 풀어보자
        String str = br.readLine(); // 문자 입력
        int M = Integer.parseInt(br.readLine()); // 명령어 개수 입력

        Stack<String> leftSt = new Stack<String>(); // 두개의 스택 정의
        Stack<String> rightSt = new Stack<String>();

        //처음 커서는 문장의 맨 뒤에서 시작하기 때문에 왼쪽 스택에 초기 문자를 모두 넣어줌 (ex. abc|)
        String[] arr = str.split("");
        for(String s : arr) { //Enhanced For Loop 사용
            leftSt.push(s);
        }

        for(int i = 0; i < M; i++) {
            String command = br.readLine(); // 명령어 입력
            char c = command.charAt(0); // 명령어 확인
            //StringTokenizer st = new StringTokenizer(reader.readLine());
            //String c = st.nextToken();

            switch(c) {
                case 'L': // 왼쪽으로 이동
                    if(!leftSt.isEmpty()) // 왼쪽 스택이 비지 않았다면
                        rightSt.push(leftSt.pop()); // 왼쪽 스택의 것을 오른쪽 스택으로 빼간다

                    break;
                case 'D': // 오른쪽으로 이동
                    if(!rightSt.isEmpty()) // 오른쪽 스택이 비지 않으면
                        leftSt.push(rightSt.pop()); // 왼쪽 스택으로 빼간다

                    break;
                case 'B': // 왼쪽 문자 삭제
                    if(!leftSt.isEmpty()) {
                        leftSt.pop(); // 왼쪽 스택의 값 삭제
                    }
                    break;
                case 'P': // 문자 삽입
                    char t = command.charAt(2);
                    leftSt.push(String.valueOf(t)); // 왼쪽 문자 삽입
                    //leftSt.push(st.nextToken());

                    break;
                default:
                    break;
            }
        }

        //Stack은 LIFO 구조이기 때문에
        //왼쪽 스택에 있는 데이터들을 모두 오른쪽으로 옮긴 뒤에 오른쪽에 있는 모든 내용을 출력한다.
        while(!leftSt.isEmpty()) // 왼쪽 스택에 값이 남은 경우
            rightSt.push(leftSt.pop()); // 오른쪽 스택으로 값을 옮긴다

        while(!rightSt.isEmpty()) // 오른쪽 스택에 값이 남은 경우
            bw.write(rightSt.pop()); // 해당 스택 출력

        bw.flush();
        bw.close();
    }
}
