package algorithm.baekjoon.step.intensification1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj25206 {
    // 등급이 p 또는 f인데 p인경우 점수 제외
    public static void main(String[] args) throws IOException {
        String[][] grade = new String[20][3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sumGrade = 0;
        double sumScore = 0;

        for(int i = 0 ; i < 20 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            grade[i][0] = st.nextToken(); // 과목 이름 저장
            grade[i][1] = st.nextToken(); // 학점 저장
            grade[i][2] = st.nextToken(); // 등급 저장

            if(!grade[i][2].equals("P")) { // p등급은 제외한다
                sumScore += calcGrade(Double.parseDouble(grade[i][1]), grade[i][2]);
                sumGrade += Double.parseDouble(grade[i][1]);
            }
        }

        if(sumScore != 0) {
            sumScore /= sumGrade;
        }

        System.out.printf("%f", sumScore);
    }

    private static double calcGrade(double score, String grade) {
        double sum = 0;

        switch (grade) {
            case "A+":
                sum = score * 4.5;
                break;

            case "A0":
                sum = score * 4.0;
                break;

            case "B+":
                sum = score * 3.5;
                break;

            case "B0":
                sum = score * 3.0;
                break;

            case "C+":
                sum = score * 2.5;
                break;

            case "C0":
                sum = score * 2.0;
                break;

            case "D+":
                sum = score * 1.5;
                break;

            case "D0":
                sum = score * 1.0;
                break;
        }
        return sum;
    }
}
