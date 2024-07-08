package com.dsa.phase1.stack;

import java.util.Stack;

public class MinStack_nSpace {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.pushStack(8);
        minStack.pushStack(7);
        minStack.pushStack(6);
        minStack.pushStack(3);
        minStack.pushStack(5);
        minStack.pushStack(4);
        minStack.pushStack(1);

        minStack.popStack();
        minStack.popStack();
        minStack.popStack();
        minStack.popStack();
        minStack.popStack();
        minStack.popStack();
        minStack.popStack();
    }

}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> tempStack;

    public MinStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public Integer getMin() {
        return tempStack.peek();
    }

    public Integer pushStack(Integer item) {
        stack.push(item);
        if (tempStack.isEmpty()) {
            tempStack.push(item);
        } else if (item < tempStack.peek()) {
            tempStack.push(item);
        }
        return item;
    }

    public Integer popStack() {
        int item;
        if (!tempStack.isEmpty() && tempStack.peek() == stack.peek()) {
            item = stack.pop();
            tempStack.pop();
        } else {
            item = stack.pop();
        }
        return item;
    }


}