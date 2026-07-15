package com.leetcode;

import com.leetcode.heap.Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class SayHello {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(9);
        heap.insert(89);
        heap.insert(7);

        ArrayList<Integer> sor = heap.heapSort();

        System.out.println(sor);
    }
}
