class Solution {
    public int rob(int[] nums) {
        int one = 0;
        int two = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = Math.max((nums[i] + one), two);
            one = two;
            two = curr;
        }

        return two;
        
    }
}
/*

nums --> each index is the amound of money in that ith house


[10, 30, 20, 30, 20]

*/
