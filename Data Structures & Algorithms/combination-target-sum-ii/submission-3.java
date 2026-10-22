class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return res;


        
    }

    public void dfs(int[] candidates, int target, int i, int sum, List<Integer> sub) {

        

        if (sum == target){
            res.add(new ArrayList<>(sub));
            return;
        }

        if (sum > target) return;

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue; // to skip dumplicates

        sub.add(candidates[j]);
        sum += candidates[j];

        dfs(candidates, target, j+1, sum, sub);

        sub.remove(sub.size() - 1);
        sum -= candidates[j];

        }
        
        
    }
}

/*
imp
the same prob can we drawn in diff ways, could have three or two branches
Exactly 2 branches, every time (like take / skip) → write 2 calls by hand, no loop.
More than 2, or the number changes from node to node → use a loop.

    base case
        - when sum == target -> add sub to res -> return
    add num to sub
    increment sum with the candidates[i]


2,3,2 - 5 -> 2,3
9,2,2,4,6,1,5 - 8 -> 2,2,4 - 

1,2,3   4               0
                    /   |   \
                    1   2   3               
                    /\  |
                    2 3 3
                    
dfs
    keep going down incrementing sum
    when i == H of tree && sum == target
    then add it to list and return

*/

