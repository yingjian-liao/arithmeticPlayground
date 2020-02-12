package com.company.chapter_5_linkedListAndRecursion;

import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }


    public ListNode(int arr[]) {
        if (arr == null || arr.length==0) {

        }
        this.val = arr[0];
        ListNode cur = this;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ListNode cur = this;

        while (cur != null) {
            stringBuilder.append(cur.val+" -> ");
            cur = cur.next;
        }

        stringBuilder.append(" NULL ");
        return stringBuilder.toString();
    }
}
