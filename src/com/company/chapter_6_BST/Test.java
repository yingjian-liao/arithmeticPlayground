package com.company.chapter_6_BST;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int array[] = {5,3,6,8,4,2,9,7};
        Random random = new Random();
//        for (Integer e :
//                array) {
//            bst.add(e);
//        }


        for (int i = 0; i < 100; i++)
            bst.add(random.nextInt(1000));


        ArrayList<Integer> list = new ArrayList<>();

        while (!bst.isEmpty()) {
            list.add(bst.removeMin());
        }

        System.out.println(list);

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1)>list.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }

//        bst.preOrder();

//        System.out.println();
//        System.out.println(bst);
//        bst.preOrderNR();

//        System.out.println();
//        bst.inOrder();
    }

    private static int add(int[] array, int i) {
        if (i == array.length)
            return 0;

        return array[i] + add(array, i + 1);
    }
}
