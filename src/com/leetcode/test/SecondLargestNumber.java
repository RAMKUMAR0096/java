package com.leetcode.test;

import java.util.*;

public class SecondLargestNumber {
    public static int secondLargeNumber(int[]arr){
        int largest = arr[0];

        //first largest
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest,arr[i]);
        }

        //second largest
        int secondLargest = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == largest){
                continue;
            }else {
                secondLargest = Math.max(secondLargest,arr[i]);
            }
        }

        return secondLargest;
    }
    static void main(String[] args) {
        int[] input = {10,20,30,40,70,100};
        System.out.println(secondLargeNumber(input));
    }
}
