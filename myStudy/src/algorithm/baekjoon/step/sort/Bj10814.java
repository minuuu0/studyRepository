package algorithm.baekjoon.step.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Bj10814 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        Person[] p = new Person[n];

        for(int i = 0; i < n; i++){
            p[i] = new Person(sc.nextInt(), sc.next());
        }

        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        for(Person peo : p){
            System.out.println(peo.age + " " + peo.name);
        }


    }

    static class Person{
        int age;
        String name;

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

}
