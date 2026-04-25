package com.leetcode;

import javax.security.auth.login.AccountLockedException;

public class Sieve {
    public static void main(String[] args) {
        int n = 40;
        boolean [] primes = new boolean[n+1];
        sieve(n,primes);
    }
    static void sieve(int n,boolean[] primes){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if(!primes[i]){
                for(int j = i*2;j<=n;j+=i){
                    primes[j] = true;
                }
            }
        }
        for(int i = 2;i <= n;i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }


}
