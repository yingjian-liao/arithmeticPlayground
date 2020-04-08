package com.company.other.sortArithmetic;

public class Main {
    public static void main(String[] args) {

        int[] array = {2, 9, 1, 6, 3, 4};

//        bubbleSort(array, '<');
        selectionSort(array);

    }

    private static void selectionSort(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("array is null or array length is zero");

        printInfo(array, false);
        for (int index = 1; index < array.length; index++) {

//            1 ~ array.length之间的元素
            int temp = array[index];
            int k = index - 1;
//            一直将index位置的元素与index-1位置的元素作对比，确定数据进行移动的范围
            while (k >= 0 && array[k] > temp)
                k--;

//            移动数据
            for (int j = index; j > k + 1; j--)
                array[j] = array[j - 1];

//            目标位置的数据
            array[k + 1] = temp;
        }
        printInfo(array, true);
    }

    private static void bubbleSort(int[] array, char order) {

        if (array == null || array.length == 0)
            throw new IllegalArgumentException("array is null or array length is zero");

        if (order != '<' && order != '>')
            throw new IllegalArgumentException("order must be '<' or '>'");

        int arrayLength = array.length;

        printInfo(array, false);

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                boolean flag = order == '>' ? array[j] > array[j + 1] : array[j] < array[j + 1];
                if (flag) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        printInfo(array, true);
    }


    private static void printInfo(int array[], boolean done) {
        StringBuilder builder = new StringBuilder();

        builder.append(done ? "after : " : "before : ");
        for (int i = 0; i < array.length; i++) {
            builder.append(i == array.length - 1 ? array[i] : array[i] + ",");
        }

        System.out.println(builder.toString());
    }
}
