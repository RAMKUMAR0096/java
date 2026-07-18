package com.leetcode.huffmancoder;


import com.leetcode.heap.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Huffman {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost;//frequency
        Node left;
        Node right;

        public Node(Character data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public Huffman(String feeder) throws Exception{
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < feeder.length(); i++) {
            char cc= feeder.charAt(i);
            if(freqMap.containsKey(cc)){
                int ov = freqMap.get(cc);
                ov = ov + 1;
                freqMap.put(cc,ov);
            }
            freqMap.put(cc,1);
        }

        Heap<Node> minheap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();

        for(Map.Entry<Character, Integer> entry : entrySet){
            Node node = new Node(entry.getKey(),entry.getValue());
            minheap.insert(node);
        }

        while (minheap.size() != 1){
            Node first = minheap.remove();
            Node second = minheap.remove();

            Node newNode = new Node('\0',first.cost + second.cost);
            newNode.left = first;
            newNode.right =second;

            minheap.insert(newNode);
        }

        Node fullTree = minheap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(fullTree, "");
    }

    private void initEncoderDecoder(Node node, String outputSoFor) {
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            this.encoder.put(node.data,outputSoFor);
            this.decoder.put(outputSoFor, node.data);
        }

        initEncoderDecoder(node.left,outputSoFor + "0");
        initEncoderDecoder(node.right,outputSoFor + "1");
    }

    public String encode(String source){
        String ans = "";

        for (int i = 0; i < source.length(); i++) {
            ans = ans + encoder.get(source.charAt(i));
        }

        return ans;
    }

    public String decode(String codedString){
        String key = "";
        String ans = "";
        for (int i = 0; i < codedString.length(); i++) {
            key = key + codedString.charAt(i);
            if(decoder.containsKey(key)){
                ans+= decoder.get(key);
                key = "";
            }
        }

        return ans;
    }


}
