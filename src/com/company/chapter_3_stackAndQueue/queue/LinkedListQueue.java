package com.company.chapter_3_stackAndQueue.queue;

import com.company.chapter_4_linkedList.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        //如果节点的next为空，说明该节点为链表中的最后一个节点
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return " "+e+" ";
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /*当tail和head为空时，队列为空 */
    @Override
    public void enqueue(E e) {
        if (tail==null) {
            tail = new Node(e);
            head = tail;
        }else{
//          每添加一个新节点，都要维护一下tail
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw  new IllegalArgumentException("Queue is empty,cannot dequeue element");

//        每次出队一个，都要维护一下head
        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head==null)
            tail = null;

        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue front > ");

        Node cur = head;
        while (cur != null) {
            stringBuilder.append(cur+"->");
            cur = cur.next;
        }

        stringBuilder.append(" NULL tail");
        return stringBuilder.toString();
    }
}
