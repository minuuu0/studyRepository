package algorithm.baekjoon.foundation.graph;

import java.util.*;
import java.io.*;

public class Bj1991 {

    static Map<Character, Node> tree = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char ln = st.nextToken().charAt(0);
            char rn = st.nextToken().charAt(0);

            tree.put(root, new Node(root, ln, rn));
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');

    }

    public static void preOrder(char root) {
        if (root == '.') return;
        System.out.print(root);
        preOrder(tree.get(root).left);
        preOrder(tree.get(root).right);
    }

    public static void inOrder(char root) {
        if (root == '.') return;
        inOrder(tree.get(root).left);
        System.out.print(root);
        inOrder(tree.get(root).right);
    }

    public static void postOrder(char root) {
        if (root == '.') return;
        postOrder(tree.get(root).left);
        postOrder(tree.get(root).right);
        System.out.print(root);
    }


    static class Node{
        char value;
        char left;
        char right;

        Node(char value, char left, char right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }



    }

}
