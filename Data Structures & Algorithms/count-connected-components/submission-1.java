class Solution {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {

        int count = 0;

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)){ count++;
            dfs(i);}
        }

        return count;

    }
    public void dfs(int n) {
        if (visited.contains(n)) return;

        visited.add(n);

        for (int nei: map.get(n)){
            dfs(nei);
        }

    }
}
/*

n = 4
0,1 0,2 1,3 3,4

0 - 1 - 3 -4
-2

 we make a loop to go over every edge, then we check how many connected combonents we have
 check all the n's that are connected to the first n, then put them in a DS
 then check the second n
    if its not in the first graph(not in the list), then create a new graph put it in the list, count + 1

    put them in hashmap


// I'll use DFS

    check all the elm



*/