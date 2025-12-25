package edu.code.fourth_st;

import java.util.*;

class MaxHeap {
    ArrayList<Integer> items;

    MaxHeap(){
        this.items = new ArrayList<>();
        this.items.add(null);
    }

    public void insert(int val) { // [null, 3, 4, 2, 9] -> [null, 9, 4, 2, 3]
        this.items.add(val);
        int cur_index = this.items.size() - 1;
        while(cur_index != 1) {
            int parent_index = cur_index / 2;
            if(this.items.get(cur_index) > this.items.get(parent_index)) {
                int tmp = this.items.get(cur_index);
                this.items.set(cur_index, this.items.get(parent_index));
                this.items.set(parent_index, tmp);
                cur_index = parent_index;
            } else {
                break;
            }
        }
    }

    public int delete() { // [null, 8, 6, 7, 2, 5, 4]
        // Swap root with last element
        int temp = this.items.get(1);
        this.items.set(1, this.items.get(this.items.size() - 1));
        this.items.set(this.items.size() - 1, temp);

        int prevMax = this.items.remove(this.items.size() - 1); // 8
        int curIndex = 1;

        while (curIndex <= this.items.size() - 1) {
            int leftChildIndex = curIndex * 2;
            int rightChildIndex = curIndex * 2 + 1;
            int maxIndex = curIndex;

            if (leftChildIndex <= this.items.size() - 1 && this.items.get(leftChildIndex) > this.items.get(maxIndex)) {
                maxIndex = leftChildIndex;
            }

            if (rightChildIndex <= this.items.size() - 1 && this.items.get(rightChildIndex) > this.items.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }

            if (maxIndex == curIndex) {
                break;
            }

            // Swap elements
            temp = this.items.get(curIndex);
            this.items.set(curIndex, this.items.get(maxIndex));
            this.items.set(maxIndex, temp);
            curIndex = maxIndex;
        }

        return prevMax;
    }
}


public class MaxHeapInsert {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
//        heap.insert(3);
//        heap.insert(4);
//        heap.insert(2);
//        heap.insert(9);
        heap.insert(8);
        heap.insert(6);
        heap.insert(7);
        heap.insert(2);
        heap.insert(5);
        heap.insert(4);
        System.out.println(heap.items);
        heap.delete();
        System.out.println(heap.items);
    }
}
