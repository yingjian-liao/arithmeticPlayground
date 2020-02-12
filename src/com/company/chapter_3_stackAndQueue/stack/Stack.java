package com.company.chapter_3_stackAndQueue.stack;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E element);
    E pop();
    E peek();
}
