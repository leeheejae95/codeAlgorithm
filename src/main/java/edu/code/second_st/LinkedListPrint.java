package edu.code.second_st;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListPrintInfo {
    Node head;
    LinkedListPrintInfo(int value) {
        this.head = new Node(value);
    }

    public void append(int value) {
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    public Node getKthNodeFromLast(int k) {
        Node slow = this.head;
        Node fast = this.head;
        for(int i=0; i<k; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}


public class LinkedListPrint {

    public static void main(String[] args) {
        LinkedListPrintInfo info = new LinkedListPrintInfo(6);
        info.append(7);
        info.append(8);
        System.out.println(info.getKthNodeFromLast(2).data);
    }
}
