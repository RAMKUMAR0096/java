package com.codeforces.contest.Number1138;


import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long p = Long.parseLong(st.nextToken());

            long[] a = new long[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(a);

            // Calculate suffix sums
            long[] suff = new long[n + 1];

            for (int i = n - 1; i >= 0; i--) {
                suff[i] = suff[i + 1] + a[i];
            }

            long ans = 0;

            // Try all possible juice glasses
            for (int j = 0; j <= n / k; j++) {

                long juice = j * p;
                long fresh = suff[j * k];

                ans = Math.max(ans, juice + fresh);
            }

            System.out.println(ans);
        }
    }
}

