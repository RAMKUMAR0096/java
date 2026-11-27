package com.codeforces.contest.Number1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    static  int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b){
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int x = gcd(l, a);
            int y = gcd(l, b);

            int ans = l / lcm(x, y);
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}

