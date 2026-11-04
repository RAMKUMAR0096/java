package com.codeforces.youthcodingclub.prefixsum;

import java.util.Scanner;
public class B{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int q = scan.nextInt();

        long prefix[] = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = scan.nextInt();
            prefix[i] = prefix[i - 1] + num;
        }

        while (q > 0){
            int l = scan.nextInt();
            int r = scan.nextInt();

            long sum = prefix[r] - prefix[l - 1];
            System.out.println(sum);
            q--;
        }
    }
}