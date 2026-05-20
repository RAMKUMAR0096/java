package com.leetcode.stackandqueue;

public class CustomCircularQueue {
    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    public CustomCircularQueue(int size) {
        this.data = new int[size];
    }

    public CustomCircularQueue() {
        this.data = new int[DEFAULT_SIZE];
    }

    private int front = 0;
    private int end = 0;
    private int size = 0;;

    public boolean add(int item){
        if(isFull()){
            System.out.print("Circular queue is full");
            return false;
        }
        data[end] = item;
        end++;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove(){
        if(isEmpty()){
            System.out.print("Circular Queue is Empty ");
            return -1;
        }

        int removed = data[front];
        front++;
        front = front % data.length;
        size--;

        return removed;
    }

    public void display(){
        if (isEmpty()) return;
        int i = front;
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i = i % data.length;
        }while (i !=end);
        System.out.println("END");
    }

    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }
}
