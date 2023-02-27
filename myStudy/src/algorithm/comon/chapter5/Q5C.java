package algorithm.comon.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q5C {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long getLargestRectangleArea(int n, Histogram[] histograms) {

        Stack<Histogram> continuedHistograms = new Stack<>();
        long answer = 0;

        continuedHistograms.push(new Histogram(-1, 0));
        for(int i = 0; i < n + 1; i++){
            Histogram h = null;
            if(i < n){ // h를 이용해서 순회한다
                h = histograms[i];
            }else{ // i == n 마지막 값에는 가짜 데이터를 넣는다
                h = new Histogram(n, 0);
            }
            // 2 1 4 5 1 3 3
            while (continuedHistograms.size() > 1 && continuedHistograms.peek().height >= h.height){
                Histogram lh = continuedHistograms.pop(); // lh는 스택에서 pop()한 값이 들어간다
                Histogram bh = continuedHistograms.peek();

                long width = h.leftX - bh.rightX; // 너비 공식
                long height = h.height; // 높이
                long area = width * height; // 넓이 구하기

                answer = Math.max(area, answer); // 기존의 값중에 최대값을 비교
            }
            continuedHistograms.push(h);
        }
        return answer;
    }

    private static void testCase(int caseIndex) throws IOException{
        int n = Integer.parseInt(br.readLine()); // 기둥의 수 n
        Histogram[] histograms = new Histogram[n]; // 객체배열

        // 기둥의 높이 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
           histograms[i] = new Histogram(i, Integer.parseInt(st.nextToken()));
        }

        long answer = getLargestRectangleArea(n, histograms);
        System.out.println(answer);

    }

    public static void main(String[] args) throws IOException {

        int caseSize = Integer.parseInt(br.readLine());

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }

    }
}
class Histogram{
    public int leftX; // 인덱스 혹은 히스토그램 왼쪽 변의 x 좌표
    public int rightX; // 히스토그램 오른쪽 변의 x좌표
    public int height;
    Histogram(int index, int height){
        this.height = height;
        this.leftX = index;
        this.rightX = this.leftX + 1;
    }
}
