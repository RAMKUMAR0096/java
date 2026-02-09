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

class Leetcode {
    static void main(String[] args) {
        FindTheDifference ftd = new FindTheDifference();
        System.out.print(ftd.findTheDifference("ram kumar","ram kumar c"));
    }
}


