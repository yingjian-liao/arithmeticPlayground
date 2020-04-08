package com.company.chapter_6_BST;

public class Test {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int array[] = {5,3,6,8,4,2,9,7};

        for (int e:array) {
            bst.add(e);
        }

        bst.postOrder();

    }

    private static int add(int[] array, int i) {
        if (i == array.length)
            return 0;

        return array[i] + add(array, i + 1);
    }
}
