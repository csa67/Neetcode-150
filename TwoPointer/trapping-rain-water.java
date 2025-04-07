package TwoPointer;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
class Solution  {
    /*
     * Water can't be trapped on tall buildings, because they would slide down. So, the water is trapped between buildings,
     * calculate the left tallest and right tallest buildings and water trapped is the min of the height.
     */
    public int trappedRainingWater(int[] nums){
        int n=nums.length;
        int ans=0;

        for(int i=1; i<n-1;i++){
            int left_max=0,right_max=0;

            for(int j=i; j>=0;j--){
                left_max = Math.max(left_max, nums[j]);
            }

            for(int j=i;j<n;j++){
                right_max = Math.max(right_max, nums[j]);
            }

            ans+=Math.max(left_max,right_max)-nums[i];

        }

        return ans;
    }
    //TC- O(n^2), SC-O(1)

    public int trappedRainingWater2(int[] nums){
        int n=nums.length;
        int ans=0;
        int current=0;
        Deque<Integer> st = new LinkedList<Integer>();

        while(current < n){
            while(!st.isEmpty() && nums[current] > nums[st.peek()]){
                int top = st.pop();
                if(st.isEmpty()) break;
                int distance = current-st.peek()-1;
                int bounded_height = Math.min(nums[current],nums[st.peek()]) - nums[top];
                ans+=distance*bounded_height;
            }
        }
        return ans;
    }
    //TC - O(n), Space - O(n)
    /*
     * I don't need both right and left max, i'll only need the min of 2, so I use 2 pointer
     */
    public int trappedRainingWater3(int[] nums){
        int n=nums.length;
        int ans=0;
        int left=0, right = n-1;
        int left_max = 0, right_max = 0;

        while(left<right){
            if(nums[left] < nums[right]){
                left_max = Math.max(left_max,nums[left]);
                ans+=left_max-nums[left++];
            }else{
                right_max=Math.max(right_max,nums[right]);
                ans+=right_max-nums[right--];
            }
        }
        return ans;
    }
}
