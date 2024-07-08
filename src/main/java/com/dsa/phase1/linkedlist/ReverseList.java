package com.dsa.phase1.linkedlist;

public class ReverseList {

    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    // null<-85->15->4->20->null
    //  |p   |c  |next 

    Node reverse(Node head){

        Node prev = null;
        Node next = null;
        Node curr = head;
        while( curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    void print(Node head){
        while(head != null){
            System.out.print( head.data + " " );
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ReverseList list = new ReverseList();

        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.next = new Node(66);
        list.head.next.next.next.next.next = new Node(32);
        list.head.next.next.next.next.next.next = new Node(10);

        System.out.println("List ");
        list.print(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("After reversed List ");
        list.print(head);

    }




}
