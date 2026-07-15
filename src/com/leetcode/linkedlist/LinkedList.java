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

    void delete_first(){
        Node temp = head;
        head = temp.next;
        size--;
        return;
    }

    void delete_last(){
        Node temp = head;

        while (temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
        size--;
        return;
    }

    void deleteAt_index(int index){

        if(index == 0){
            delete_first();
            return;
        }

        if(index == size - 1){
            delete_last();
            return;
        }
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
        return;
    }

    void display_linked_list(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void insert_using_recurion(int index, int value){
        if(index > size){
            System.out.println("Enter index upto: " + size);
            return;
        }
        head = insertUsingRecurision(index,value,head);
    }

    private Node insertUsingRecurision(int index, int value, Node node){

        if(index == 0){
            Node newNode = new Node(value,node);
            size++;
            return newNode;
        }

        node.next = insertUsingRecurision(index = index - 1,value,node.next);
        return node;
    }

    static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAt_begeining(5);
        ll.insertAt_begeining(10);
        ll.insertAt_begeining(15);
        ll.insertAt_begeining(20);
        ll.insertAt_begeining(25);
        ll.insertAt_last(0);
        ll.display_linked_list();
        ll.insert_using_recurion(3,23);
        ll.display_linked_list();
    }
}
