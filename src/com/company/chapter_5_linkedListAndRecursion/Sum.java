package com.company.chapter_5_linkedListAndRecursion;

public class Sum {

    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    // 计算arr[l...n)这个区间内所有数字的和
    private static int sum(int[] arr, int l){

        if(l == arr.length)
            return 0;

        int i = arr[l];
        int sum = sum(arr, l + 1);
        return i + sum;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums = {1, 2, 3};
        System.out.println(sum(nums));
    }
}
