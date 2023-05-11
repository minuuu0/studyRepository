import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Bj10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();

        while (N-- > 0) {
            String command = sc.next();

            switch (command) {
                case "push_front":
                    int x = sc.nextInt();
                    deque.offerFirst(x);
                    break;
                case "push_back":
                    int y = sc.nextInt();
                    deque.offerLast(y);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(deque.pollFirst()).append('\n');
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty": // 값이 있으면 0 없으면 1
                    if (deque.isEmpty()) {
                        sb.append("1").append('\n');
                    } else {
                        sb.append("0").append('\n');
                    }
                    break;
                case "front": // 맨 앞 원소 꺼내기
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(deque.peekFirst()).append('\n');
                    }
                    break;
                case "back": // 맨 뒤 원소 꺼내기
                    if (deque.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(deque.peekLast()).append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
