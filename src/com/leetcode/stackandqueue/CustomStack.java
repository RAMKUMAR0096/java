package com.leetcode.stackandqueue;

public class CustomStack {
    protected int[] data;

    private int ptr = -1;

    private static final int DEFAULT_SIZE = 10;

    public CustomStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop(){
        if(isEmpty()){
            System.out.print("Stack is empty ");
            return -1;
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }
}
