package com.dsa.phase1.stack;

import java.util.Stack;

public class MinStack_0Space {

    int min;
    Stack<Integer> stack = new Stack<>();

    //keep track of min element in a stack?
    public static void main(String[] args) {

        MinStack_0Space minstack = new MinStack_0Space();
        minstack.pushStack(6);
        System.out.println("MIN :: " + minstack.getMin());
        minstack.pushStack(3);
        minstack.pushStack(2);
        minstack.pushStack(1);
        minstack.pushStack(7);
        minstack.pushStack(1);
        minstack.pushStack(3);
        minstack.popStack();
        minstack.popStack();
        minstack.popStack();
        minstack.popStack();
        minstack.popStack();
        minstack.popStack();
        minstack.popStack();

    }

    private int getMin() {
        return min;
    }

    private int popStack() {
        if (stack.isEmpty()) {
            return -1;
        } else if (stack.peek() <= min) {
            int item = min;
            min = min * 2 - stack.pop();
            if (stack.isEmpty()) min = -1;
            return item;
        } else {
            return stack.pop();
        }
    }

    private void pushStack(int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            min = item;
        } else if (item <= min) {
            stack.push(2 * item - min);
            min = item;
        } else {
            stack.push(item);
        }
    }
}





/*
====== Optimized code ======

package com.dsa.phase1.stack;

import java.util.Stack;

public class MinStack_0Space {

    private int min;
    private Stack<Integer> stack;

    public MinStack_0Space() {
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {
        MinStack_0Space minStack = new MinStack_0Space();
        minStack.push(6);
        System.out.println("MIN :: " + minStack.getMin());
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        minStack.push(7);
        minStack.push(1);
        minStack.push(3);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return min;
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int top = stack.pop();
        if (top <= min) {
            int originalMin = min;
            min = 2 * min - top;
            return originalMin;
        } else {
            return top;
        }
    }

    public void push(int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            min = item;
        } else if (item <= min) {
            stack.push(2 * item - min);
            min = item;
        } else {
            stack.push(item);
        }
    }
}

 */