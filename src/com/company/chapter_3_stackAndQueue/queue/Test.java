package com.company.chapter_3_stackAndQueue.queue;


public class Test {
    public static void main(String[] args) {
        Queue<Integer> loopQueue = new LoopQueue<Integer>(5);

        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
    }
}
