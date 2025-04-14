package DP.oned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * Recursive backtracking
     * TC-O(2^n) SC-O(n)
     */
    public int lengthOfLIS(int[] nums) {
        int min = Integer.MIN_VALUE;
        return backtrack(0,min,nums);
    }

    private int backtrack(int i, int max, int[] nums){
        if(i==nums.length){
            return 0;
        }

        int pick = 0;
        if(nums[i] > max){
            pick = 1+backtrack(i+1,nums[i], nums);
        }
        
        int notpick = backtrack(i+1,max,nums);

        return Math.max(pick,notpick);
    }

    /*
     * With memoization
     */
        public int lengthOfLIS2(int[] nums) {
            int[][] memo = new int[nums.length][nums.length + 1];
            for (int[] row : memo) 
                Arrays.fill(row, -1);
            return backtrack(0, -1, nums, memo);
        }
    
        private int backtrack(int i, int prevIndex, int[] nums, int[][] memo) {
            if (i == nums.length) return 0;
    
            if (memo[i][prevIndex + 1] != -1) return memo[i][prevIndex + 1];
    
            int pick = 0;
            if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
                pick = 1 + backtrack(i + 1, i, nums, memo);
            }
    
            int notPick = backtrack(i + 1, prevIndex, nums, memo);
    
            return memo[i][prevIndex + 1] = Math.max(pick, notPick);
        }

        /*
         * 1D dp
         * TC-O(n^2) SC-O(n) 
         */

        public int lengthOfLIS3(int[] nums){
            int n=nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp,1);

            for(int i=0; i<=n-1;i++){
                for(int prev=0;prev<=i-1;prev++){
                    if(nums[prev] < nums[i]){
                        dp[i] = Math.max(dp[i],1+dp[prev]);
                    }
                }
            }

        int ans = -1;
        
            for(int i=0; i<=n-1; i++){
                ans = Math.max(ans, dp[i]);
            }
            
            return ans;
        }
        
        /*
         * Binary + greedy approach:
         * 
         * add increasing nums to subseq, if current num is less than the last element of subseq, 
         * replace the smallest num >= current,
         * it is optimal to have smaller numbers if we want increasing subsequence.
         * 
         *          
         * */
            public int lengthOfLISOptimal(int[] nums) {
                int n=nums.length;
                
                List<Integer> subseq = new ArrayList<>();
                subseq.add(nums[0]);
        
                for(int i=1;i<n;i++){
                    if(nums[i] > subseq.get(subseq.size() - 1)){
                        subseq.add(nums[i]);
                    }else{
                        int index = binarySearch(subseq, nums[i]);
                        subseq.set(index,nums[i]);
                    }
                }
        
                return subseq.size();
            }
        
            private int binarySearch(List<Integer> nums, int target){
                int ans = -1;
        
                int low=0;
                int high=nums.size()-1;
        
                while(low<=high){
                    int mid=low+(high-low)/2;
        
                    if(nums.get(mid) < target){
                        low=mid+1;
                    }else{
                        ans=mid;
                        high=mid-1;
                    }
                }
        
                return ans;
            }
        }
