class Solution {

    HashMap<Integer, List<Integer>> map = new HashMap<>(); // for checkin cycle
    HashSet<Integer> visited = new HashSet<>();
    boolean cycle;

    public int[] findRedundantConnection(int[][] edges) {

        for (int[] k: edges) {
            int a = k[0];
            int b = k[1];
            
            if (!map.containsKey(a)) map.put(a, new ArrayList<>());
            if (!map.containsKey(b)) map.put(b, new ArrayList<>());

            map.get(a).add(b);
            map.get(b).add(a);

            visited.clear();
            cycle = false;
            dfs(-1,a);

            if (cycle) return new int[]{a,b};


        }
        return new int[]{}; 
    }

    public void dfs(int parent, int node) {
        if (cycle) return;
        visited.add(node);
        
       
        for (int nei: map.get(node)) {
            if (nei == parent) continue;
            if (visited.contains(nei)) {
                cycle = true;
                return;
            }
            dfs(node, nei);
        }
    }
}
/*
nei != parent AND visited.contains(nei) → cycle ✅

first put all the dges in a list
each n with its nei, using two loops , first for n's, and other for 


1 [2,3]
2 [1,4]
3 [1,4]
4 [2,3]


*/