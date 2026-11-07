package com.codeforces.youthcodingclub.prefixsum;

import java.io.BufferedInputStream;
import java.io.IOException;

public class F {
    static class FastReader {
        BufferedInputStream in = new BufferedInputStream(System.in);

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            long num = 0;
            int sign = 1;
            int c;

            do {
                c = in.read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = in.read();
            }

            while (c > ' ') {
                num = num * 10 + c - '0';
                c = in.read();
            }

            return num * sign;
        }
    }
    public static void main(String[] args) throws IOException{
        FastReader s = new FastReader();

        int n = s.nextInt();

        long max = Integer.MIN_VALUE;
        long currSum = 0;

        for (int i = 1; i <=n ; i++) {
            long x = s.nextLong();
            currSum = Math.max(x, currSum + x);
            max = Math.max(max, currSum);
        }
        System.out.println(max);
    }
}
