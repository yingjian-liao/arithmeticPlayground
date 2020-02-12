package com.company.chapter_4_linkedList;

public class LinkedList<E> {

    public class Node {
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


    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //    在头部添加元素
    public void addFirst(E e) {
//        Node node1 = new Node(e);
//        node1.next = head;
//        head = node1;

//        Node node = new Node(e, dummyHead);
//        dummyHead = node;
//        size++;

        add(0, e);
    }

    //    在指定位置添加元素
    public void add(int index, E e) {
        if (index < 0 && index > size)
            throw new IllegalArgumentException("index error");

        Node prev = dummyHead;
//        获取到index位置的上一个元素
        for (int i = 0; i < index; i++)
            prev = prev.next;

            Node node = new Node(e);
            node.next = prev.next;//新节点的next节点 接管 prev节点的next节点
            prev.next = node;//新节点必须成为 prev节点的next节点

//        prev.next = new Node(e, prev.next);
        size++;
    }


//    重点在于，找到待删除节点的上一个节点，然后拆除连接，然后重建连接
    public E remove(int index){
        if (index < 0 && index > size)
            throw new IllegalArgumentException("index error");

        Node prev = dummyHead;

        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }


    public E get(int index) {
        if (index < 0 && index > size)
            throw new IllegalArgumentException("index error");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    public void set(int index, E e) {
        if (index < 0 && index > size)
            throw new IllegalArgumentException("index error");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }


    public boolean contains(E e) {
        Node cur = dummyHead.next;

        while (cur != null) {
            if (cur.e.equals(e))
                return true;

            cur = cur.next;
        }
        return false;
    }


    public Node getDummyHead(){
        return this.dummyHead;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst(){ return get(size-1); }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            stringBuilder.append(cur + "->");
            cur = cur.next;
        }


//        for(Node cur = dummyHead.next;cur !=null;cur = cur.next)

        stringBuilder.append("NULL");

        return stringBuilder.toString();
    }
}
