package com.leetcode.stackandqueue;


public class StackAndQueue {
    static void main(String[] args) {
        DynamicCustomStack stack = new DynamicCustomStack(4);
        stack.push(4);
        stack.push(40);
        stack.push(42);
        stack.push(44);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
