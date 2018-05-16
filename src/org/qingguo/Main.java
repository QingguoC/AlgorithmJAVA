package org.qingguo;

import java.util.PriorityQueue;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        System.out.println(random.nextInt(2));
        System.out.println(random.nextInt(2));
        System.out.println(random.nextInt(2));
        System.out.println(random.nextInt(2));
        System.out.println(random.nextInt(2));
        System.out.println(1 << 2);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(3);
        q.add(4);
        q.add(2);
        q.add(3);
        System.out.println(q.size());
        System.out.println(false ^ false);
    }
}
