package com.leetcode.trees;

public class AVLTree {
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

    public int height(){
        if(root == null){
            return -1;
        }
        return root.height;
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

        return rotate(node);
    }

    private Node rotate(Node node) {
        if(height(node.left) - height(node.right) > 1){
            //left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                //left left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                //left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left) - height(node.right) < -1){
            //right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                //right right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                // right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node node) {
        Node p = node.right;
        Node t = p.left;

        p.left = node;
        node.right = t;

        node.height = Math.max(height(node.left), height(node.right) + 1);
        p.height = Math.max(height(p.left), height(p.right) + 1);

        return p;
    }

    private Node rightRotate(Node node) {
        Node c = node.left;
        Node t = c.right;

        c.right = node;
        node.left = t;

        node.height = Math.max(height(node.left), height(node.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }
}