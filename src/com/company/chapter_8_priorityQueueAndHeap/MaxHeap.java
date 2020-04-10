package com.company.chapter_8_priorityQueueAndHeap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }


    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }


    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int i = leftChild(k);
//            判断K节点是否有右孩子，同时右孩子是否比左孩子要大，如果是的话，就用K的右孩子和K去作比较。
            if (i + 1 < data.getSize() && data.get(i + 1).compareTo(data.get(i)) > 0)
                i++;
//            如果K已经大于左右孩子了，此时的循环也就没有意义了。
            if (data.get(k).compareTo(data.get(i)) >= 0)
                break;
//            如果K小于左右孩子，则交换他们的顺序。
            data.swap(k,i);
            k = i;
        }
    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.getSize(); i++) {
            stringBuilder.append("【"+i+"】 "+data.get(i)).append(" -> ");
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }



    private String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }


}
