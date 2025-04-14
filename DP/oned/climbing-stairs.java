package DP.oned;

class Solution {
    //Recursive
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }

        if(n==0) return 1;

        return climbStairs(n-1) + climbStairs(n-2);
    }

    //TC- O(2^n), SC-O(n)

    //Memoization
        public int climbStairs2(int n) {
            int memo[] = new int[n + 1];
            return climb_Stairs(0, n, memo);
        }
    
        public int climb_Stairs(int i, int n, int memo[]) {
            if (i > n) {
                return 0;
            }
            if (i == n) {
                return 1;
            }
            if (memo[i] > 0) {
                return memo[i];
            }
            memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
            return memo[i];
        }
        //TC- O(n), SC-O(n)
    
        //Tabulation
        public int climbStairs3(int n) {
            int[] dp = new int[n+1];

            dp[0] = dp[1] = 1;

            for(int i=2; i<=n;i++){
                dp[i] = dp[i-1]+dp[i-2];
            }

            return dp[n];
        }
        //TC- O(n), SC-O(n)

        //Tabulation - space optimization
        public int climbStairs4(int n) {
            
            int prev2=1;
            int prev1 = 1;

            for(int i=2; i<=n;i++){
                int curr = prev1 + prev2;
                prev2 = prev1;
                prev1 = curr;
            }

            return prev1;
        }

    
}