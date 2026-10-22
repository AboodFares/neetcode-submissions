class Solution {
    public int maxSubArray(int[] nums) {

        int currsum = 0;
        int maxsum = nums[0];

        for (int i = 0; i < nums.length; i++) {

            currsum += nums[i];
            
            maxsum = Math.max(currsum, maxsum);

           if (currsum < 0) currsum = 0;

            
        }
        return maxsum;

        
    }
}
// greedy just a way of when to pick the best choice and never come back

//contiguous = next to each other

// [-2, 3, 5, 9, -7, 6, 2, 8]
//  currsum -2, 3, 5, 9, -7, 6, 2, 8
//  maxsum. -2, 3, 8, 17, 17, 17, 17, 17

// reset curr = 0 when its -

// we check if currsum became smaller then we start from the ind after
