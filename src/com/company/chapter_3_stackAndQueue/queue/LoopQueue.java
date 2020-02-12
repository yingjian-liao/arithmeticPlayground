package com.company.chapter_3_stackAndQueue.queue;

public class LoopQueue<E> implements Queue<E> {
//    tail指向下一个没有数据的新空间
//    front指向第一个数据
    private int front,tail,size;
    private E data[];


    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
//        需要浪费一个空间，避免tail与front重叠
        data = (E[]) new Object[capacity+1];
        front=0;
        size=0;
        tail=0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail==front;
    }

    @Override
    public void enqueue(E e) {
//        队列已满，进行扩容
        if ((tail+1) % data.length == front)
            resize(getCapacity()*2);
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new NullPointerException("queue is empty");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size -- ;
//        当size为原来的四分之一时，进行缩容操作
        if (size == getCapacity() / 4 && getCapacity()/2 !=0)
            resize(getCapacity() / 2);

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new NullPointerException("queue is empty");
        }
        return data[front];
    }

    public int getCapacity(){
        return data.length - 1;
    }
    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++)
//            font并非一定等于0，又因是循环，进行求余，确保能够拿到所有元素
           newData[i] = data[(i+front % data.length)];

        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");

        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            E data = this.data[i];

            res.append(data);
            if((i + 1) % this.data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}