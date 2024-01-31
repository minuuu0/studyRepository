package algorithm.baekjoon.silver;

import java.lang.*;
import java.util.*;
import java.io.*;

class Bj19636
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main (String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        int weight = Integer.parseInt(st.nextToken()); // 체중
        int defaultbasal = Integer.parseInt(st.nextToken()); // 초기 기초 대사량
        int T = Integer.parseInt(st.nextToken()); // 역치

        st = new StringTokenizer(br.readLine());
        int dietDay = Integer.parseInt(st.nextToken()); // 다이어트 일 수
        int dietGetEnergy = Integer.parseInt(st.nextToken()); // 에너지 섭취량
        int activityEnergy = Integer.parseInt(st.nextToken()); // 일일 활동 대사량

        int basal = defaultbasal; // 기초 대사량


        int change = dietGetEnergy - (basal + activityEnergy);
        // 기초 대사량 변화를 고려하지 않는 경우
        int weight1 = weight + change * dietDay;
        String result1 = (weight1 <= 0) ? "Danger Diet" : weight1 + " " + basal; // 조건에 따라 체중과 기초대사량 출력

        System.out.println(result1);

        // 기초 대사량 변화를 고려하는 경우
        // w : weight, l0 : defaultBasal, t : T, d: day, l : dietGetEnergy, a : activityEnergy, x : basal
        boolean danger = false;

        for (int i = 0; i < dietDay; i++) {
            weight += change; // 체중변화

            if (Math.abs(change) > T) { // 역치보다 크면 /2
                if (change < 0) {
                    change *= -1; // 음수 -> 양수로
                    change = change / 2;
                    change *= -1;
                }
                basal += change; // 기초대사량 갱신
            }

            if (weight <= 0 || basal <= 0) {
                System.out.println("Danger Diet");
                danger = true;
                break;
            }

        }

        // 위험하지 않은 경우
        if (danger == false) {
            System.out.print(weight + " " + basal);
            if (defaultbasal <= basal) {
                System.out.println(" NO");
            } else {
                System.out.println(" YOYO");
            }
        }

    }
}
