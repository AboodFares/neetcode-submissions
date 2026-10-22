class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i>= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    
    }
}

 /*
 1,2,0,1,0


 dp[4] = true
 dp[3] = true
 dp[2] = false
 dp[1] = dp[nums[i] +1 ]
 dp[1] = dp[nums[i] + 1]



 */

 // How to attack any greedy problem

//Rewrite the problem in your own words.
//Ask yourself: "What's the one thing I need to remember as I walk through?" (running sum, farthest reach, and so on)
//Write the rule for each step.
//Try to break it with a tricky small example.
//ode it, usually as one loop.