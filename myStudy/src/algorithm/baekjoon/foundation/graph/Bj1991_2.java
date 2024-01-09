package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bj1991_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Character, Node> map;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 이진 트리 노드의 개수

        map = new HashMap<Character, Node>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char val = st.nextToken().charAt(0);
            char ln = st.nextToken().charAt(0);
            char rn = st.nextToken().charAt(0);
            map.put(val, new Node(val, ln, rn));
        }



        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
    }

    private static void preOrder(char value) {
        if (value == '.') return;
        Node node = map.get(value);
        System.out.print(value);
        preOrder(node.ln);
        preOrder(node.rn);
    }

    private static void inOrder(char value) {
        if (value == '.') return;

        Node node = map.get(value);
        inOrder(node.ln);
        System.out.print(value);
        inOrder(node.rn);
    }

    private static void postOrder(char value) {
        if (value == '.') return;

        Node node = map.get(value);
        postOrder(node.ln);
        postOrder(node.rn);
        System.out.print(value);
    }

    static class Node {
        char val;
        char ln;
        char rn;
        Node(char val, char ln , char rn){
            this.val = val;
            this.ln = ln;
            this.rn = rn;
        }
    }

}
