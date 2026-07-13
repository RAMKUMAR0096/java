package com.leetcode.linkedlist;

public class LinkedList {

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    Node head;
    int size = 0;

    void insertAt_begeining(int value){
        if(head == null){
            Node node = new Node(value);
            head = node;
            size++;
            return;
        }

        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;

    }

    void insertAt_last(int value){

        if(head == null){
            insertAt_begeining(value);
            return;
        }

        Node temp = head;

        while (temp.next != null){
            temp = temp.next;
        }
        Node node = new Node(value);
        temp.next = node;
        size++;
    }

    void insertAt_index(int index, int value){

        if(index == 0){
            insertAt_begeining(value);
            return;
        }

        if(index < 0){
            System.out.println("Index starts from 0");
            return;
        }

        if(index > size){
            System.out.println("Enter index upto: " + size);
            return;
        }

        if(size == index){
            insertAt_last(value);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(value,temp.next);
        temp.next = node;
        size++;

    }

    void display_linked_list(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAt_begeining(5);
        ll.insertAt_begeining(10);
        ll.insertAt_begeining(15);
        ll.insertAt_begeining(25);
        ll.insertAt_last(0);
        ll.insertAt_index(1,20);
        ll.insertAt_index(6,-5);
        ll.insertAt_index(-1,-5);
        ll.insertAt_index(200,-5);
        ll.display_linked_list();
    }
}
