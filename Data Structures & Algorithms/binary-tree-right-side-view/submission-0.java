/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        if (root == null){
            return result;
        }

        q.offer(root);
        TreeNode node = root;
        
        while(!q.isEmpty()) {

            int size = q.size();
            

            for (int i = 0; i < size; i++) {
                node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }  
            }
            result.add(node.val);
        } return result;
    }
}

// ok so basically we retrun the rightmost node's value of each level

//ok so my first idea is since we are aiming for the rightmost node of each level we can vist them level by level useing bfs

//ok so we also need a data structure to keep track of the nodes and travel between them, so we use queue

// if right is null then add left

