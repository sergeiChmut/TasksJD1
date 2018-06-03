package com.lectures.lecture9;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> stack = new LinkedList<>();
    public void push (T in) {
        stack.addFirst(in);
    }
    public T pop() {
        return stack.removeFirst();
    }
    public boolean empty() {
        return stack.isEmpty();
    }
}
