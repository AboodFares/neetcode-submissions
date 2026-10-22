class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] small = new int[n];
        int[] big = new int[n];

        big[n-1] = nums[n-1];
        small[n-1] = nums[n-1];
        int answer = nums[n-1];

        for (int i = n - 2; i >= 0; i--) {
            
            int alone = nums[i];
            
            big[i] = Math.max(alone, Math.max(nums[i]*small[i+1], nums[i]*big[i+1]));
            small[i] = Math.min(alone, Math.min(nums[i]*small[i+1], nums[i]*big[i+1]));
               answer = Math.max(answer, big[i]);

        }
        return answer;
        
    }
}
/*
if -

smallest[3] = nums[3]*smalest[4]
if +
largest[3] = nums[3]*largest[4]

for each iteration keep the smallert and the biggest


[2] -> 2
[2,3] -> 6
[2,3,-1] -> 6
[2,3,-1,7] -> 7

2,4,-3,5

dp[4] = 0
dp[3] = 5  max(dp[i], dp[i]*dp[i+1])
dp[2] = 5  max(dp[i], dp[i]*dp[i+1])
dp[1] = 4 max(dp[i], dp[i]*dp[i+1])
dp[0] = 2 max(dp[i], dp[i]*dp[i+1])

2,4,-3,5,-3

dp[5] = 0
dp[4] = -3
dp[3] = 5
dp[2] = 5 but it should be 45    max(dp[i], dp[i]*dp[i+1]

smallest[4] = -3
largest[4] = 1

if -
smallest[3] = nums[3]*smalest[4]
if +
largest[3] = nums[3]*largest[4]


we need to find the max subarray, stop when negative, but store it there, incase there is another negative
what if there are two negative nums


return int, the largets product of the subarray

note, - * - is positive


dp[i] = the biggest product of a subarray that starts exactly at index i.
*/