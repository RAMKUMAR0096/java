package com.codeforces.contest.Number2290;

import java.util.Scanner;

public class ThreePiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();

        while(i-- > 0){
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            int num3 = scan.nextInt();

            if(num2 - num1 == 1 && num3 - num2 == 1){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }

    }
}
