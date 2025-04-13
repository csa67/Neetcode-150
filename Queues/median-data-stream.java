package Queues;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> leftHalf;  // max-heap
    PriorityQueue<Integer> rightHalf; // min-heap

    public MedianFinder() {
        leftHalf = new PriorityQueue<>((a, b) -> b - a); // max heap
        rightHalf = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        if (leftHalf.isEmpty() || num <= leftHalf.peek()) {
            leftHalf.add(num);
        } else {
            rightHalf.add(num);
        }

        // Balance the heaps
        if (leftHalf.size() > rightHalf.size() + 1) {
            rightHalf.add(leftHalf.poll());
        } else if (rightHalf.size() > leftHalf.size() + 1) {
            leftHalf.add(rightHalf.poll());
        }
    }

    public double findMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            return (leftHalf.peek() + rightHalf.peek()) / 2.0;
        } else if (leftHalf.size() > rightHalf.size()) {
            return leftHalf.peek();
        } else {
            return rightHalf.peek();
        }
    }
}

