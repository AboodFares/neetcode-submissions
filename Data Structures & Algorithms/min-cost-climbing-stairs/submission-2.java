class Solution {
    

    public int minCostClimbingStairs(int[] cost) {

       int one = 0;
       int two = 0;

       for (int i = cost.length - 1; i >=0; i--) {
        int curr = cost[i] + Math.min(two, one);
        two = one;
        one = curr;
       }

       return Math.min(two, one);
    }
    
}

/*

make an array to store

for loop from the last index and keep subtracting until first node

arr[i] = min(arr[i + 1],  arr[i + 2])


dp[i] only needs i-1 and i-2 → bottom-up with two variables
Anything else → top-down (memo)

minimum cost to reach
*/
