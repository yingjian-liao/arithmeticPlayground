package com.company.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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



//        int[] array = {1,1,2,2,2,2};
//        int[] array = {0,0,0,1,1,1,2,2,2};
        int[] array = {0,0,2,2,2,2,2,2};

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node2.next = node3;

        head.next = node2;

        reverseList(head);

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

  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }


  }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;



            curr.next = prev;
            prev = curr;



            curr = nextTemp;
        }
        return prev;
    }
}
