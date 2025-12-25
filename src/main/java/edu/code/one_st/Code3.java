package edu.code.one_st;
// LinkedList 문제
class LinkedListNode {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public LinkedListNode(int value) {
        this.head = new Node(value);
    }

    public void append(int value) {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    public void printAll() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public Node getNode(int index) {
        Node cur = this.head;
        int curIndex = 0;

        while (curIndex != index) {
            cur = cur.next;
            curIndex += 1;
        }

        return cur;
    }

    public void addNode(int index, int value) {
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        Node prevNode = this.getNode(index - 1);
        Node nextNode = prevNode.next;
        prevNode.next = newNode;
        newNode.next = nextNode;
    }

    public void deleteNode(int index) {
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        Node prevNode = this.getNode(index - 1);
        Node indexNode = this.getNode(index);
        // prev index next
        // [7]->[5]->[6]->[12]->[8]
        prevNode.next = indexNode.next;
    }
}

class Code3 {
    public static void main(String[] args) {
        LinkedListNode linkedList = new LinkedListNode(5);
        linkedList.append(12);
        linkedList.append(8);
        linkedList.printAll();
        linkedList.addNode(1, 6);
        linkedList.addNode(0, 7);
        linkedList.deleteNode(1);
        linkedList.printAll();

        // head
        //      head
        // [7]->[6]->[12]->[8]
        linkedList.deleteNode(0);
        // [6]->[12]->[8]
        linkedList.printAll();
    }
}