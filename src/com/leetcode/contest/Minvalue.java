package com.leetcode.contest;

public class Minvalue {
    static void main(String[] args) {
        int a = 19;
        int b = 20;
        String s = ""+a+b;
        int af = Integer.parseInt(s);
        System.out.println(af);
    }
}


class Solution {

    public long minimumMaxValue(int n, int index, int value) {

        // Store the input as required by the question
        long[] ravonexqil = {n, index, value};

        n = (int) ravonexqil[0];
        index = (int) ravonexqil[1];
        value = (int) ravonexqil[2];

        // Find the smallest prime factor of value
        int p = smallestPrimeFactor(value);

        // If value = 1, GCD with every number is 1
        if (p == -1) {
            return -1;
        }

        // Check whether we can fill the left side
        if ((long) value - p < 2L * index) {
            return -1;
        }

        // Number of elements required after index
        int right = n - index - 1;

        // If no elements are required on the right
        if (right == 0) {
            return value;
        }

        // First next number is value + p
        // Remaining numbers increase by 2
        return (long) value + p + 2L * (right - 1);
    }

    // Find the smallest prime factor
    private int smallestPrimeFactor(int num) {

        if (num < 2) {
            return -1;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return i;
            }
        }

        return num;
    }
}
