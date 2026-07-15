package com.leetcode.heap;

import java.util.ArrayList;

public class Heap <T extends Comparable<T>> {
    private ArrayList<T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    private void swap (int first, int second){
        T firstElement = list.get(first);
        T secondElement = list.get(second);
        list.set(first,secondElement);
        list.set(second,firstElement);
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private int left(int index){
        return index * 2 + 1;
    }

    private int right(int index){
        return index * 2 + 2;
    }

    public void insert(T value){
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {

        if(index == 0){
            return;
        }

        int parent = parent(index);
        if(index < list.size() && list.get(index).compareTo(list.get(parent)) < 0){
            swap(index, parent);
            upheap(parent);
        }
    }

    public T remove() throws Exception{
        if (list.isEmpty()){
            throw new Exception("Removing from the empty heap!!");
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);

        if (!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int min = index;

        int left = left(min);
        int right = right(min);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }

        if(min != index){
            swap(min, index);
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> sort = new ArrayList<>();
        while (!list.isEmpty()){
            sort.add(this.remove());
        }

        return sort;
    }
}
