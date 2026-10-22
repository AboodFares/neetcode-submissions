class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = nums.length - 1; i >= 0; i--) {     // numbers: backward
            for (int s = target; s >= nums[i]; s--) {    // sums: backward
                dp[s] = dp[s] || dp[s - nums[i]];
            }
        }
        return dp[target];
    }
}
/*
if we can partion the set into two equal substes return true, otherwise return false

target = all the values added together, divide them by 2
now the sum of each subset must equal to target
lets build the first subset ---> equals target, then add the rest of the values, if = target they return true

1,2,3,4         target = 5
dp[4] = true
dp[3] = t
dp[2] = f


“fewest / cheapest” → min
“most / biggest” → max
“how many ways” → +
“is it possible” → ||


type three of dp, building up a target
*/
