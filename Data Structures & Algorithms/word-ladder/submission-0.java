class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, List<String>> map = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();

        if (!wordList.contains(endWord)) return 0;
        

        for (String n: wordList) {
            map.put(n, new ArrayList<>());
        }
        
        for (int i = 0; i < wordList.size(); i++) { 
           for (int j = i + 1; j < wordList.size(); j++) {
            String a = wordList.get(i);
            String b = wordList.get(j);
            if (od(a, b)) {
                map.get(a).add(b);
                map.get(b).add(a);
            }
           }
        }
        if (!map.containsKey(beginWord)) {
        map.put(beginWord, new ArrayList<>());
        for (String w : wordList) {
            if (od(beginWord, w)) map.get(beginWord).add(w); 
        }
    }

    // now use bfs to find the min num of steps to arrive
    HashSet<String> visited = new HashSet<>();
    q.add(beginWord);
    visited.add(beginWord);
    int steps = 1;
    

    while (!q.isEmpty()) { // one level per round (steps++)
        int size = q.size();

        for (int i = 0; i < size; i++) { // each word on this level
            String node = q.poll();
            if (node.equals(endWord)) return steps;

            for (String nei: map.get(node)) { // that word’s neighbors, which go into the next level
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.add(nei);
                }
            }
        }
        steps++;

    }return 0;


    }
    public boolean od(String a, String b) {
        int differ = 0;
        for (int i = 0; i < a.length(); i++) {
             if (a.charAt(i) != b.charAt(i)) differ++;
        }
        return differ == 1;
       
    }
}
/*
all the words have same length
all lowercase
all distinct

transform rules:
    - have exctly one diff char, rest are same
    - chang
    - keep doing that with other words
    - until its transformed to endword
    - return the min num of calculating steps

    Answer
        - make a hashmap, and store all teh nei together


How to tell, in any problem: ask yourself, “if A connects to B, does B automatically connect to A?”
if yes then undirect
if no then direct

to mark already seen
    HashSet for any nodes
    boolean[] for numbers or grids
    Change the input (grid[r][c] = '0')
    Remove it from a set
    HashMap of copies (Clone Graph) 

*/