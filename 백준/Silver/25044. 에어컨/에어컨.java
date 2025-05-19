import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. init
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] add = {180, 180, 1080 + k}; // 추가 시간
        AirConTime timing = new AirConTime(900, 0); // 시간, 일차
        ArrayList<Integer> result = new ArrayList<>(); // N일차에 해당하는 시간을 저장
        int idx = 0;

        while (timing.day <= n) {
            if (timing.day == n) {
                result.add(timing.time);
            }
            timing = calc(timing, add[idx]);
            idx = (idx + 1) % 3;
        }

        System.out.println(result.size());
        for (int i : result) {
            System.out.println(minToTime(i));
        }

    }

    private static String minToTime(int minute) {
        int hour = minute / 60;
        int min = minute % 60;
        return String.format("%02d:%02d", hour, min);
    }

    private static AirConTime calc(AirConTime p, int add) {
        int newTime = (p.time + add) % 1440;
        int newDay = p.day + ((p.time + add) >= 1440 ? 1 : 0);
        return new AirConTime(newTime, newDay);
    }

    static class AirConTime {
        int time;
        int day;

        AirConTime(int time, int day) {
            this.time = time;
            this.day = day;
        }
    }

}