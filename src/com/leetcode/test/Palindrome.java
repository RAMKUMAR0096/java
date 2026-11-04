package com.leetcode.test;

public class Palindrome {

    public static boolean palindrome(String str){
        String original = str;
        String rev = reverse(str);
        return original.equals(rev);
    }

    private static String reverse(String str){
        char[] message = str.toCharArray();
        int start = 0;
        int end = message.length -1;
        while (start <= end){
            char temp = message[start];
            message[start] = message[end];
            message[end] = temp;
            start++;
            end--;
        }

        String output = "";
        for (int i = 0; i < message.length; i++) {
            output += message[i];
        }
        return output;
    }
    static void main(String[] args) {
        String input = "malayalam";
        System.out.println(palindrome(input));
    }
}
