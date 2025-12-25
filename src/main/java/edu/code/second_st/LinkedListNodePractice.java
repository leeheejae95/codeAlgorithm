package edu.code.second_st;

class LinkedListNodePc {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public LinkedListNodePc(int value) {
        this.head = new Node(value);
    }

    public void append(int value) {
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    public void printAll() {
        Node cur = this.head;
        while(cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public Node getIndex(int index) {
        Node cur = this.head;
        int cur_index = 0;
        while(cur_index != index) {
            cur = cur.next;
            cur_index += 1;
        }
        return cur;
    }

    public void addNode(int index, int value) {
        Node new_node = new Node(value);

        if(index == 0) {
            new_node.next = this.head;
            this.head = new_node;
            return;
        }

        Node prev_node = this.getIndex(index-1);
        Node next_node = prev_node.next;
        prev_node.next = new_node;
        new_node.next = next_node;
    }
    
    public void deleteNode(int index) {
        if(index == 0) {
            this.head = this.head.next;
            return;
        }
        
        Node prev_node = this.getIndex(index-1); // 현재노드
        Node index_node = this.getIndex(index); // 제거할 노드
        prev_node.next = index_node.next; // 현재노드 앞에 제거할 노드 앞의 노드를 연결 시켜야됨
    }
}

public class LinkedListNodePractice {

    public static void main(String[] args) {
        LinkedListNodePc listNodePractice = new LinkedListNodePc(5);
        listNodePractice.append(12);
        listNodePractice.append(8);
        System.out.println("------------------------------------------------------");
        listNodePractice.printAll();
        System.out.println("------------------------------------------------------");
        System.out.println(listNodePractice.getIndex(2).data);
        System.out.println("------------------------------------------------------");
        listNodePractice.addNode(0,7);
        listNodePractice.printAll();
        System.out.println("------------------------------------------------------");
        listNodePractice.deleteNode(1);
        listNodePractice.printAll();

    }
}
