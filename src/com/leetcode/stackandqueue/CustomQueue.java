package com.leetcode.stackandqueue;

public class CustomQueue {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean add(int item){
        if(isFull()){
            System.out.println("Queue is full");
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove(){
        if(isEmpty()){
            System.out.print("Queue is Empty ");
            return -1;
        }
        int removed = data[0];
        for (int i = 1; i < data.length; i++) {
            data[i - 1] = data[i];
        }
        end--;

        return removed;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public boolean isFull() {
        return end == data.length;
    }
}
