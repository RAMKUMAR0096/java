package com.leetcode.stackandqueue;


public class StackAndQueue {
    static void main(String[] args) {
        CustomQueue queue = new DynamicCustomQueue(2);

        queue.add(44);
        queue.add(4);
        queue.add(24);
        queue.add(89);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
