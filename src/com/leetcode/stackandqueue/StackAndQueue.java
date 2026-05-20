package com.leetcode.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
    static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(45);
        stack.push(44);
        stack.push(22);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(49);
        queue.add(42);
        queue.add(4);
        queue.add(2);
        queue.add(66);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
