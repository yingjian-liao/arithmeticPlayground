package com.company.chapter_8_priorityQueueAndHeap;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 1000000;
        int[] array = {6,7,8,9,54};

        MaxHeap<Integer> maxHeap = new MaxHeap<>();


        for (int i : array) {

            maxHeap.add(i);

        }


        maxHeap.extractMax();

        System.out.println(maxHeap);



//        Random random = new Random();
//        for(int i = 0 ; i < n ; i ++)
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//
//        int[] arr = new int[n];
//        for(int i = 0 ; i < n ; i ++)
//            arr[i] = maxHeap.extractMax();
//
//        for(int i = 1 ; i < n ; i ++)
//            if(arr[i-1] < arr[i])
//                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");
    }
}
