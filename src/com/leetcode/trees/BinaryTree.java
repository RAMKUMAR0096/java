package com.leetcode.trees;

import java.util.Scanner;

public class BinaryTree {
    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    public void populate(Scanner scanner, Node node){
        System.out.println("Do you want to insert left of node " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of left node : ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to insert right of node " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of right node : ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }
    }

    public void preetyDisplay(){
        preetyDisplay(root, 0);
    }

    private void preetyDisplay(Node node, int level) {
        if(node == null){
            return;
        }
        preetyDisplay(node.right, level+1);

        if(level != 0){
            for (int i = 0; i < level -1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|--------->" + node.value);
        }else {
            System.out.println(node.value);
        }

        preetyDisplay(node.left, level + 1);
    }


}
