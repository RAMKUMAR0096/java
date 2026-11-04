package com.codeforces.youthcodingclub.prefixsum;
//
//import java.util.Scanner;
//
//public class D {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int n = scan.nextInt();
//        int m = scan.nextInt();
//
//        int prefix[] = new int[n + 1];
//
//        for(int i = 1;i <= n;i++){
//            prefix[i] = scan.nextInt();
//        }
//
//        while(m > 0){
//            int l = scan.nextInt();
//            int r = scan.nextInt();
//            int x = scan.nextInt();
//
//            for (int start = l; start <= r ; start++) {
//                prefix[start] += x;
//            }
//            m--;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if(i == n){
//                System.out.print(prefix[i]);
//            }else{
//                System.out.print(prefix[i] + " ");
//            }
//        }
//    }
//}

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        long[] arr = new long[n + 1];
        long[] diff = new long[n + 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextLong();
        }

        while (m > 0) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            long x = scan.nextLong();

            diff[l] += x;
            diff[r + 1] -= x;

            m--;
        }

        long current = 0;

        for (int i = 1; i <= n; i++) {
            current += diff[i];
            arr[i] += current;

            System.out.print(arr[i]);

            if (i < n) {
                System.out.print(" ");
            }
        }

        scan.close();
    }
}
