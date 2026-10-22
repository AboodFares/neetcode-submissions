class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int a: coins) {
                if (a <= i) {
                     dp[i] = Math.min(dp[i], 1+ dp[i - a]);
                }
            }
        }

        return dp[amount] > amount ? -1: dp[amount];
    }
}
/*
1,2,5       11
dp[0] = 0;
dp[1] = 1 + dp[0] = 1
dp[2] = 1 + dp[0] = 1
dp[3] = 1 + dp[1] = 2
dp[4] = 1 + dp[2] = 2
dp[5] = 1 + dp[0] = 1
dp[6] = 1 + dp[1] = 2
dp[7] = 1 + dp[2] = 2

first loop
    go over every amount from 0 -> amount
second loop
    go over every index in coins and check which one to take
    then dp[subtract a with amount] + 1(the grates num and the smaller than i)
    

for each 

*/