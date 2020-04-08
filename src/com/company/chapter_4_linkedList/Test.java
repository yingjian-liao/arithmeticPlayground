package com.company.chapter_4_linkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
        }


        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.removeElement(666);
        System.out.println(linkedList);
//
//        LinkedList.Node node = linkedList.getDummyHead();
//
//        while (node.next != null) {
//            node = node.next;
////                System.out.println(node.e);
//        }


//        for (LinkedList.Node mNode = linkedList.getDummyHead().next; mNode!=null ; mNode = mNode.next) {
//            System.out.println(mNode.e);
//        }


//        for (int i = 0; i < linkedList.getSize(); i++) {
//            System.out.println(linkedList.get(i));
//        }

//
//        linkedList.remove(3);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);

    }
}