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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot == null) return true;

        if (root == null) return false;

        if (sametree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
        isSubtree(root.right, subRoot);
   
    }
    public boolean sametree(TreeNode a, TreeNode b) {// here we suppose same
        if (a == null && b == null) return true;

        if (a == null || b == null || a.val != b.val) return false;

        return (sametree(a.left, b.left) && sametree(a.right, b.right));
    }



}
 // when do i stop, when for root and subroot, left and right == null,   true
    // if we get to a point where both true with the condition are equals, true

    // when conidtion aplying but one of them is not null, then false

    // ook so both must end together
    // what do i ask the curr children
    // what i do in the next node
// dfs until we see subroot val, then we start comparing

// we compare every left and right nodes together, until subroot equals null

