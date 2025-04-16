package greedy;

/*
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
class Solution {
    /*
     * You need to find the minimum jumps needed to reach the end and are guarenteed to reach the end.
     * For every step you take from i, you can start any where between (i+1, i+nums[i])
     * track the farthest index I can reach at each step. When I hit the end of my current jump range, I increase the jump count and update the range. 
     */
    public int jump(int[] nums) {
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            curFar = Math.max(curFar, i + nums[i]);

            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }
}
