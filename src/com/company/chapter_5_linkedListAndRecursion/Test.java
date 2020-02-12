package com.company.chapter_5_linkedListAndRecursion;

public class Test {
    public static void main(String[] args) {
        int nums[] = {1, 6, 2, 3, 4, 5, 6, 6};

        ListNode head = new ListNode(nums);

        System.out.println(fb2(4));

//        ListNode node = new Solution().removeElements2(head, 6);
//        System.out.println(node);
    }

    public static int fb2(int num) {
        //判断：是否是第一个数和第二个数
        if (num == 1 || num == 2)
            return 1;

        return fb2(num - 2) + fb2(num - 1);
    }
}
