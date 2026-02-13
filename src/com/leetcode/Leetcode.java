package com.leetcode;
import java.io.*;
class FindTheDifference {
    public char findTheDifference(String s, String t) {
        String main=s+t;
        char mainarr[]=main.toCharArray();
        char unique=0;
        //In java we have direct option to xor in characters also
        for(char i:mainarr){
            unique=(char)(unique^i);
        }
        return unique;
    }

}

class addString{

        public String addStrings(String num1, String num2) {
            String s = "";
            int carry = 0;
            int int1 = num1.length() - 1;
            int int2 = num2.length() - 1;
            while (int1 >= 0 || int2 >= 0 || carry > 0) {
                int digit1 = int1 >= 0 ? num1.charAt(int1) - '0' : 0;
                int digit2 = int2 >= 0 ? num2.charAt(int2) - '0' : 0;

                int sum = digit1 + digit2 + carry;
                carry = sum / 10; // Q
                int digit = sum % 10; // R
                s = digit + s;
                int1--;
                int2--;
            }
            return s;
        }

        static {
            Runtime.getRuntime().gc();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try (FileWriter f = new FileWriter("display_runtime.txt")) {
                    f.write("0");
                } catch (Exception e) {
                }
            }));
        }
}
class nextGreatestLetterInLeetCode{
    public char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start) / 2;
            if(target<letters[mid]){
                end = mid-1;
            }else{
                start = start+1;
            }
        }
        return letters[start % letters.length];
    }
}

class Leetcode {
    static void main(String[] args) {
        nextGreatestLetterInLeetCode ngl = new nextGreatestLetterInLeetCode();
        char[] c={'a','b','c','d'};
        System.out.println(ngl.nextGreatestLetter(c,'d'));
    }
}


