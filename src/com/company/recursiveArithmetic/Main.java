package com.company.recursiveArithmetic;

public class Main {

    /*
    使用纳秒来测试算法
     */

    public static void main(String[] args) {

        long nanoTime = System.nanoTime();
//      转成秒
        double second = nanoTime / 100000000.0;
//        从第三项开始，每一项都等于(n-2)+(n-1)
//        fb1();
//        System.out.println(fb2(4));

        int[] array = {1,2,3};

//        System.out.println(calculateSum(array,0));


        filterPrimeNumber2(100);
//
//        chengfabiao();


    }

    private static void chengfabiao() {
        for (int i = 1; i <=9 ; i++) {
//            1 -> i
            for (int j = 1; j <= i; j++) {
                System.out.print(j +" * " +i +" = "+(i*j)+"  ");
            }
            System.out.println();
        }
    }

    private static void filterPrimeNumber(int i) {
        if(i<2){
            throw new IllegalArgumentException("range error");
        }
        for (int j = 2; j < i; j++) {
            int a = 2;

            while(j%a!=0){
                a++;
            }

            if(j==a){
                System.out.println(j);
            }

        }
    }


    private static void filterPrimeNumber2(int ii) {
        boolean flag;

        for (int i = 2; i < ii; i++) {
            flag = true;
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
//            代表i没有被i(i>=2)之前的数整除
            if (flag) {
                System.out.println(i);
            }
        }


    }

    private static int calculateSum(int[] array, int index) {
//        最基本解
        if (index == array.length) {
            return 0;
        }
//        将原规模问题转化为更小的规模问题
        int i = calculateSum(array, index + 1);
        return array[index] + i;
    }

    public static void fb1() {

        int a = -1, b = -1;
        for (int i = 1; i < 5; i++) {
            if (i == 1)
                a = b = i;//第一项和第二项

            System.out.print(a + "\t" + b + "\t");

            a = a + b;
            b = a + b;
        }

    }

    //建立一个函数，用于计算数列中的每一项
    public static int fb2(int num) {
        //判断：是否是第一个数和第二个数
        if (num == 1 || num == 2) {
            return 1;
        } else {
            //循环调用本函数
            int prev2 = num - 2;
            int prev1 = num - 1;
            int prev2Val = fb2(prev2);
            int prev1Val = fb2(prev1);
            int result = prev2Val + prev1Val;
            return result;
        }
    }

}
