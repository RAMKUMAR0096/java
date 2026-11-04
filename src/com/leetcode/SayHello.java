package com.leetcode;

import com.leetcode.heap.Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class SayHello {

    static int digitalRoot(int n){
        if(n== 0){
            return 0;
        }
        return (n % 9 == 0) ? 9 : n % 9;
    }

    static int findSumOfDight(int input){

        while (input >= 10){
            int output = 0;
            while (input > 0){
                int rem = input % 10;
                output = output + rem;
                input /= 10;
            }

            input = output;
        }


        return input;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(findSumOfDight(12346));
    }
}
