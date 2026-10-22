class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> path = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        
       for (int i = 0; i < numCourses; i++) {
        map.put(i, new ArrayList<>());
       }
        for (int[] pre: prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!DFS(i)) return false;
        }
        return true;
       
    }
    

    public boolean DFS(int course) {
        if (path.contains(course)) return false;
        if (map.get(course).isEmpty()) return true;

        path.add(course);
        for (int pre: map.get(course)){
            if (!DFS(pre)) return false;
        } 
        path.remove(course);

        map.get(course).clear();
        return true;

    }
}

/*

steps:
1- create a HashMap, store the course, and prereq arr
    how store?
        first store the num courses with empty list inside map
        for each arr inside prereq

2- DFS
    IF a node is visited twice in the same path then false
    each time we go back to try a difference path we unvisit the node

para we use
    1- visited



adj list,no node should have undirect edge, then its false


if a node bieng pointed to by tw nodes in the same path ---> false
if we arrive to the last node and it has empty nei ---->> true

its true when we arrive to a node that doesn't direct to any node

[0, 1], [0, 2], [1, 2]

*/

/*
VERY IMPORTANT
the most important thing is to write test cases before starting to code 
try to write multible test cases, show it to the interciewer so he can help me
keep asking while doing that

"Are there things that are connected to other things?"

What are the things? → those are your nodes
What connects them? → those are your edges

OK

*/