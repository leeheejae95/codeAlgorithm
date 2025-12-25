package edu.code.second_st;

class NodeSumPc {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    NodeSumPc(int data) {
        this.head = new Node(data);
    }

    public void append(int value) {
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }
}

public class NodeSumPractice {

    public static int getSingleLinkedListSum(NodeSumPc nodeSumPc) {
        int sum = 0;
        NodeSumPc.Node cur = nodeSumPc.head;
        while(cur != null) {
            sum = sum * 10 + cur.data;
            cur = cur.next;
        }

        return sum;
    }

    public static int getLinkedListSum(NodeSumPc nodeSum_1, NodeSumPc nodeSum_2) {
        int sum_1 = getSingleLinkedListSum(nodeSum_1);
        int sum_2 = getSingleLinkedListSum(nodeSum_2);

        return sum_1 + sum_2;
    }

    public static void main(String[] args) {
        NodeSumPc nodeSum_1 = new NodeSumPc(6);
        nodeSum_1.append(7);
        nodeSum_1.append(8);

        NodeSumPc nodeSum_2 = new NodeSumPc(3);
        nodeSum_2.append(5);
        nodeSum_2.append(4);

        System.out.println(getLinkedListSum(nodeSum_1, nodeSum_2));
    }
}
