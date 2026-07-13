package com.leetcode.string;
import java.lang.StringBuffer;
import java.util.Random;

public class StringBufferDemo {
    static void main(String[] args) {
        StringBuffer sb = new StringBuffer("This is Ram");
        //sb.append("Hello");
        String str = sb.toString();
        System.out.println(str);
        System.out.println(generateRandomString(32));
    }
    static String generateRandomString(int size){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sb.append((char)(97 + random.nextFloat()*26));
        }
        return sb.toString();
    }
}


