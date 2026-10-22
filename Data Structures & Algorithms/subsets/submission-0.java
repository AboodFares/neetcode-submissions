class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
        helper(nums, new ArrayList<>(), 0);
        return result;

    }

    public void helper(int[] nums, List<Integer> sub, int i) {
        // base case

        if (i == nums.length) {
//result.add(sub) → saves a link to the same list. If sub changes later, the saved one changes too.
//result.add(new ArrayList<>(sub)) → saves a copy. Later changes to sub don't touch it.
            result.add(new ArrayList<>(sub));
            return;
        }

        
        sub.add(nums[i]);
        helper(nums, sub, i+1);// 
        
        sub.remove(sub.size() - 1);
        helper(nums, sub, i+1);


    }

    //questions i have
    // when do i store the sub 
    // when do i store the result, if i==nums, store the current sub
    // therefore we keep changing the sub values in the method
    // what para in helper


}
//[1,2,3]
// [[0], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
// the zero is a subset of any set
// always zero

//when making the tree include or not include


// we make a tree in our head
// it would be O(n*2^n)
// we take all the leafs by comparing it if (i == nums.length)
//Space = the most extra memory my code uses at once (recursion + any maps/arrays I make). It all disappears when the code ends; only what I return stays.

// Loop over n items, then loop over n items again → n + n (add)
// Loop over n items, and inside it loop over n items → n × n (multiply).


