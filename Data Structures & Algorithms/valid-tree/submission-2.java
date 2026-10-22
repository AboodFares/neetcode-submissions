class Solution {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> path = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

            if(!dfs(0,-1)) return false;
            return path.size() == n; 
    }
    public boolean dfs(int n, int parent) {
        if (path.contains(n)) return false;

        path.add(n);

        for (int prev: map.get(n)){
             if (prev == parent) continue;
            if (!dfs(prev, n)) return false; 
        }return true;

    }
}
/*
   not a tree when
    1- a,b & c,b & a,c. how to write the edge for this one???
    2- when disconnected.  

   DFS
*/
