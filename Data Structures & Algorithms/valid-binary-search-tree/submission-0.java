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

    boolean Bo = true;

    public boolean isValidBST(TreeNode root) {
        helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
        return Bo;
    }

    public void helper(TreeNode node, long max, long min) {

        if (node == null) {
            return;
        }

        // we check if what we changed is ok or not
        if(min >= node.val || max <= node.val) {
            Bo = false;
        }
        

        helper(node.left, node.val, min);// we always change them
        helper(node.right, max, node.val);

    }
}

// left always smaller
// right always bigger
// we need a parameter max, min to keep track of the value
// if node.left < track 
// if 
