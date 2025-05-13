import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. init
        int t = Integer.parseInt(br.readLine());
        // fibo값을 미리 구해놓기
        fibo = new int[22];
        fibo[0] = 1;
        fibo[1] = 2;
        getFibo();


        for (int test_case = 0; test_case < t; test_case++) {
            int kilo = Integer.parseInt(br.readLine());
            String kiloNotation = getNotation(kilo);
            int result = changeMile(kiloNotation);
            System.out.println(result);
        }
        

    }

    private static int changeMile(String kiloNotation) {
        int result = 0;
        for (int i = 0; i < 21; i++) {
            if (kiloNotation.charAt(i) == '1') {
                result += fibo[20 - i];
            }
        }
        return result;
    }

    private static String getNotation(int kilo) {
        StringBuilder sb = new StringBuilder();
        int index = 21;
        while (index > 0) {
            if (kilo / fibo[index] >= 1) {
                sb.append("1");
                kilo %= fibo[index];
            } else {
                sb.append("0");
            }
            index--;
        }
        return sb.toString();
    }

    private static void getFibo() {
        for (int i = 2; i < 22; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }
    }


}
