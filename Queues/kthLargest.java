package Queues;

import java.util.PriorityQueue;

/*
 * You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.

You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.

Implement the KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
 */
public class kthLargest {
    /*
     * We need the kth largest element every time, so we just need to store k large elements at any point of time. we use a min heap of k elements, so we get the kth largest on the top of the heap.
     */
    PriorityQueue<Integer> minHeap;
    int k;

    public kthLargest(int k, int[] nums){
        minHeap = new PriorityQueue<>();
        this.k=k;
    }

    public int add(int num){
        if(minHeap.size() < k || minHeap.peek() < num){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
