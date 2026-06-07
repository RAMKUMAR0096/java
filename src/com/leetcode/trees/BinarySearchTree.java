package com.leetcode.trees;

public class BinarySearchTree {
    public class Node{
        private int value;
        private Node right;
        private Node left;
        private int height;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void insert(int value){
        root = insert(root,value);
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <=  1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(this.root, "Root Node : ");
    }

    private void display(Node node, String child) {
        if(node == null){
            return;
        }

        System.out.println(node.value + child);
        display(node.left, "Left child" + node.value);
        display(node.right, "Right child" + node.value);
    }

    private Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(node.left, value);
        }

        if(value > node.value){
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left),height(node.right)) + 1;

        return node;
    }


}