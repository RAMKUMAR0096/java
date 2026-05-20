package com.leetcode.stackandqueue;

public class DynamicCustomQueue extends CustomQueue{
    public DynamicCustomQueue() {
        super();
    }

    public DynamicCustomQueue(int size) {
        super(size);
    }

    public boolean add(int item){
        if (isFull()){
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
        return super.add(item);
    }
}
