package com.leetcode.stackandqueue;


public class StackAndQueue {
    static void main(String[] args) {
        CustomCircularQueue queue = new CustomCircularQueue(4);

        queue.add(49);
        queue.add(9);
        queue.add(78);
        queue.add(42);
//        queue.add(56);
        queue.display();
        queue.remove();
        queue.display();
    }
}
