class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
        
    }

    public void dfs(int[] nums, int i,  List<Integer> sub) {
        
        res.add(new ArrayList<>(sub));

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]) continue;
            sub.add(nums[j]);
            dfs(nums, j + 1, sub);
            sub.remove(sub.size() - 1);

        }
        
    }
}
/*

nums, contains dup
return all the subsets, no duplicates subsets, in any order

                           [] (i=0: decide 1)
                 /                          \
             take 1                        skip 1
             [1] (i=1)                     [] (i=1)
           /         \                    /         \
       take 2     skip ALL 2s         take 2     skip ALL 2s
      [1,2] (i=2)    [1] ✅          [2] (i=2)      [] ✅
       /      \                       /      \
   take 2    skip 2               take 2    skip 2
  [1,2,2]✅  [1,2]✅              [2,2]✅    [2]✅
here the leafs are the answer
or-------------------------------------------------------------

                         [] ✅ (start=0)
             /           |            \
          +1 (j=0)    +2 (j=1)     +2 (j=2)
          [1] ✅       [2] ✅      ✂️ SKIP (dup)
         /     \          |
     +2 (j=1) +2 (j=2)  +2 (j=2)
    [1,2] ✅  ✂️ SKIP   [2,2] ✅
       |
    +2 (j=2)
   [1,2,2] ✅
here every node is an answer
we need a loop, It’s because there are more than 2 branches,
---------------------------------------------------------------
*/