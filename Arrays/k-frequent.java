//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

/*
 * Constraints - is a unique answer guaranteed? yes
 * only +ve nums? - decide hashmap/array.
 * Does the result need to be sorted by frequency or can it be in any order? any order is fine.
 * Can multiple numbers have the same frequency?
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution{
    /*
     * Bruteforce: Get all the counts of each number, store them in a hashmap, sort them and get the top k elements.
     * 
     * Better: Instead of sorting the hashmap directly, Use a heap and get the top k elements.
     */
    private int[] getKFreqMaxHeap(int[] nums, int k){
        Map<Integer, Integer> freqCount = new HashMap<>();

        for(int i:nums){
            freqCount.put(i,freqCount.getOrDefault(i,0)+1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(
            a,b -> freqCount.get(b) - freqCount.get(a)
        );
        maxHeap.addAll(freqCount.keySet());

        int[] res = new int[k];
        for(int i=0; i<k;i++){
            res[i] = maxHeap.poll();
        }

        return res;
    }
    /*
     * This is NlogN time complexity, because you add all the elements and then get the TopK, instead you can only insert K int the heap with minheap. after the heap has k elemenets, compare if the new element has a freq k greater than that of the smallest element, only then add it.
     * which would reduce the time complexity to O(NlogK)
     */

     private int[] getKFreqMinHeap(int[] nums, int k){
        Map<Integer, Integer> freqCount = new HashMap<>();

        for(int i:nums){
            freqCount.put(i,freqCount.getOrDefault(i,0)+1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(
            a,b -> freqCount.get(a) - freqCount.get(b)
        );

        for(int n:freqCount.keySet()){
            minHeap.add(n);
            if(minHeap.size() > k) minHeap.poll();
        }   //Always holds only k elements.

        int[] res = new int[k];
        for(int i=k-1; i>0;i--){
            res[i] = minHeap.poll();
        }

        return res;
    }

    /*
     * Optimal solution - Using bucket sort.
     * 
     * Count freq of each number. 
     * use list of buckets where each bucket index represents a frequency.
     * place the numbers in the corresponding bucket based on their frequency. 
     * traverse the buckets from highest to lowest and collect top k.
     * 
     * TC- O(n) SC-O(n)
     */
    
     private int[] getKFreqOptimal(int[] nums, int k){
        Map<Integer, Integer> freqCount = new HashMap<>();

        for(int i:nums){
            freqCount.put(i,freqCount.getOrDefault(i,0)+1);
        }

        List<List<Integer>> buckets = new ArrayList(nums.length+1);

        for(int n:freqCount.keySet()){
           int freq = freqCount.get(n);
           if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
           } 
           buckets[freq].add(key);
        }  

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        // Convert result to array
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = result.get(i);
        }

        return topK;
    }

}