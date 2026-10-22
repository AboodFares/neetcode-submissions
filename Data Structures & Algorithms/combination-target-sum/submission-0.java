class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums, target, 0, new ArrayList<>(), 0);
        return result;
    }

    public void helper(int[] nums, int target, int i, List<Integer> sub, int sum) {
        if (target == sum){
            result.add(new ArrayList(sub));
            return;
        }

        if (target < sum || i == nums.length){
            return;
        }

        
        sub.add(nums[i]);
        helper(nums, target, i, sub, sum + nums[i]);
        
        sub.remove(sub.size() - 1);
        helper(nums, target, i + 1, sub, sum);

        


    }
}
// if you feel you are lost remember
// edge case, formula, call the method again(dfs)

// the edge case here is when the list is equal to the sum
// instead of for loop, you keep track of the list which is sum

// array nums(distinct ints)
// int target
// return the unique comb of nums that sum to target
// can choose the same number more than once

// ok so basically we keep going if less or equal and then if i == length we store it


//imp

// how to make the tree, in notion


// imp

// first thing came to my mind is (all comb) means backtrackingbut thats not enough
//"all" + each answer is a group built from choices → backtracking
//"all" + each answer is a single item/pair → loop, HashMap, two pointers, sliding window

//imp