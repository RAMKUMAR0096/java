package com.leetcode.test;

import org.w3c.dom.ls.LSOutput;

public class ReverseArray {

    public static void reverseArray(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        int len = input.length -1;
        reverseArray(input,0,len);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}


