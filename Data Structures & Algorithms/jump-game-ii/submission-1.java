class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0;
        int r = 0;
        
        while (r < nums.length -1) {
             int farthest =0;

             for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i +nums[i]);
             }
             l = r + 1;
             r = farthest;
             jumps++;


        } return jumps;
           
            
        
        
    }
}
/*
use bfs
all the steps together, and the first one arrive its the min steps
two loops 
    - one for each nums index
    - one for how many jumps it can make

    the edge cases
        - if arrived then return it (its the fastes one)
        - 
*/