class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int res = 1;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                res = Math.max(res, dp[i]);

            }
        }
        return res;

    }
}
/*

9,1,4,2,3,3,7

dp[6] = 1
dp[5] = 1 + how many are bigger next, for each one count++, 
dp[4] = 1 h


maximam

// go over every index after the i, and count how many are bigger





-----------IMPPPPP----------------------------------------
Look 1–2 steps ahead: dp[i] uses dp[i+1], dp[i+2]        |
Climbing Stairs, House Robber, Decode Ways, Min Cost Stairs
Look at many later spots (a loop inside a loop): dp[i] uses dp[j] for many j
LIS, Word Break
Amount / target: dp[amount] uses dp[amount - x]
Coin Change, Partition Equal Subset Sum, Combination Sum IV
Subarray ending or starting at i: the answer is the max over all i
Max Subarray, Max Product Subarray, LIS
Grid: dp[r][c] uses the cell to the right and the cell below
Unique Paths, Min Path Sum
Two strings: dp[i][j] = position i in one string, j in the other
LCS, Edit Distance
*/