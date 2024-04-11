package algorithm.baekjoon.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj23056 {

    public static class info {
        int num;
        String name;

        public info(int num, String name) {
            super();
            this.num = num;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<info> odd = new ArrayList<>(); //홀
        ArrayList<info> even = new ArrayList<>(); //짝

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학급 수
        int M = Integer.parseInt(st.nextToken()); // 학급별 인원 수

        int[] school = new int[N+1];

        Comparator<info> comp = new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                if (o1.num == o2.num) {
                    if (o1.name.length() == o2.name.length()) {
                        return o1.name.compareTo(o2.name);
                    }
                    return o1.name.length() - o2.name.length();
                }
                return o1.num - o2.num;
            }
        };

        while (true) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (num == 0 && name.equals("0")) {
                break;
            }

            if (num % 2 == 0 && school[num] < M) {
                even.add(new info(num, name));
                school[num]++;
            }
            else if (num % 2 == 1 && school[num] < M) {
                odd.add(new info(num, name));
                school[num]++;
            }
        }

        Collections.sort(odd, comp);
        Collections.sort(even, comp);

        for (int i = 0; i < odd.size(); i++) { // 홀수 먼저
            sb.append(odd.get(i).num + " " + odd.get(i).name + "\n");
        }

        for (int i = 0; i < even.size(); i++) {
            sb.append(even.get(i).num + " " + even.get(i).name + "\n");
        }

        System.out.println(sb);

    }
}
