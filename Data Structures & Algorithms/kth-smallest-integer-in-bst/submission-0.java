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

    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        helper(root, k);
        return result;
    }


    public void helper(TreeNode node, int k) {
        if (node == null || count == k) {
            return;
        }
        helper(node.left, k);
        count++;

        if (count == k){
            result = node.val;
            return;
        }

        helper(node.right, k);
        
    }
}

// since its bst, we keep going left if no left return the root