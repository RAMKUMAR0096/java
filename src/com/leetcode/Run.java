package com.leetcode;

import com.leetcode.hashmap.CustomHashMap;
import com.leetcode.hashmap.RealHashMap;
import com.leetcode.huffmancoder.Huffman;

import java.util.Scanner;

public class Run {
    static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the message: ");
        String message = scan.next();
        Huffman hm = new Huffman(message);

        String cs = hm.encode(message);
        System.out.println(cs);
        String m = hm.decode(cs);
        System.out.println(m);
    }
}
