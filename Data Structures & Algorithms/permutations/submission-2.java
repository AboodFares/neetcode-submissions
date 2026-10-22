class Solution {
   
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

          boolean[] visit = new boolean[nums.length]; 

        dfs(nums, visit, new ArrayList<>());
        return res;
      

        }
    

    public void dfs(int[] nums, boolean[] visit, List<Integer> sub) {

         if (sub.size() == nums.length) {                 // base case: full permutation
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;                      // already used, skip

            sub.add(nums[i]);                            // choose
            visit[i] = true;

            dfs(nums, visit, sub);                       // explore

            sub.remove(sub.size() - 1);                  // undo
            visit[i] = false;
        }

    
}
}

/*
create a a booleam visited that has the length ofnums
creaet an outer list that will store the sub lists, keep it global
make a list that stores the leafs(the subs), make inside the class

now create a for loop
    if (i equals to nums.length then add it to sub)

    add the ith to the sub list 
    make visited[i] == zero

    put the dfs(nums, sub, i+1)

    remove size - 1
    visited[i] =false
    
*/