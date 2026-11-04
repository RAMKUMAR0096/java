package com.codeforces.youthcodingclub.prefixsum;


import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];

        int i = 0;
        while(i < n){
            arr[i] = scan.nextLong();
            i++;
        }

        long sum = 0;
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            arr[j] = sum;
        }

        for (int j = 0; j < n; j++) {
            System.out.print(arr[j]);
            if(j != n-1){
                System.out.print(" ");
            }
        }
    }
}
