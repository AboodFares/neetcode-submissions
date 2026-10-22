/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        
        Queue<Node> q = new ArrayDeque<>();
        HashMap<Node, Node> map = new HashMap<>();

        map.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            for (int i = 0; i < curr.neighbors.size(); i++) {
                Node nei = curr.neighbors.get(i);
                if(!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                map.get(curr).neighbors.add(map.get(nei));
            }
        }
        return map.get(node); //looks up that key and gives back its value, which is the clone
    }
}

/*

node2.neighbors → [node1, node3]

create a node with og value
create the neighbors nods
map it to neighbors
keep going

1- what we need to check from the og
    - the node value
    - its neighbors
2- we use BFS, take node values and neighbors, then creat a node with the same new value and neighbors

First before building 
    how can i go over the og nodes 














*/