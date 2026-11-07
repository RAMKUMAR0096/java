package com.codeforces.youthcodingclub.prefixsum;

import java.io.BufferedInputStream;
import java.io.IOException;

public class E {
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

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int m = s.nextInt();
        int q = s.nextInt();

        long[] arr = new long[n + 1];
        long[] diff = new long[n + 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextLong();
        }

        while(m-- > 0){
            int l = s.nextInt();
            int r = s.nextInt();
            long x = s.nextLong();

            diff[l] += x;
            diff[r + 1] -= x;
        }

        long sum = 0;
        for (int i = 1; i <= n ; i++) {
            sum += diff[i];
            arr[i] += sum;
            arr[i] += arr[i - 1];
        }

        StringBuilder output = new StringBuilder();
        while(q-- > 0){
            int l = s.nextInt();
            int r = s.nextInt();
            long ans = arr[r] - arr[l - 1];
            output.append(ans).append('\n');
        }

        System.out.println(output);

    }
}
