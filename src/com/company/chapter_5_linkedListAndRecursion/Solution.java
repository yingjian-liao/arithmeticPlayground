package com.company.chapter_5_linkedListAndRecursion;

import java.util.List;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val == val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
            head = head.next;
        }

        if (head==null)
            return null;

        ListNode prev = head;
        while(prev.next!=null) {
            if(prev.next.val==val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            }
            else
                prev = prev.next;
        }
        return  head;
    }
}