class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> path = new HashSet<>();
    HashSet<Integer> done = new HashSet<>();
    List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[0];
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    private boolean dfs(int course) {
        if (path.contains(course)) return false;
        if (done.contains(course)) return true;

        path.add(course);
        for (int n : map.get(course)) {
            if (!dfs(n)) return false;
        }
        path.remove(course);

        done.add(course);
        order.add(course);
        return true;
    }
}

// No .clear(): empty list = "no prereqs" or "already done"? can't tell.
// done set tracks finished courses so each goes into order once.