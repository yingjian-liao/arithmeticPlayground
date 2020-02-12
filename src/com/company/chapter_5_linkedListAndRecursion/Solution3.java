package com.company.chapter_5_linkedListAndRecursion;

public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return null;

        head.next = removeElements(head.next,val);
        return head.val == val?head.next:head;

//        ListNode res = removeElements(head.next, val);
//        if (head.val==val)
//            return res;
//        else{
//            head.next = res;
//            return head;
//        }
    }
    public static void main(String[] args) {
//        int nums[] = {1,6,4,5,6,6};
//
//        ListNode head = new ListNode(nums);
//
//        System.out.println(head);
//
//        ListNode node = new Solution3().removeElements(head, 6);
//        System.out.println(node);


        int a=1,b=1;
        for (int i = 0; i < 5; i++) {
            if(a==1&&b==1){
                System.out.print(a+"\t"+b);
            }

            a = a+b;
            b = a+b;

            System.out.print("\t"+a+"\t"+b);
        }


    }


}
