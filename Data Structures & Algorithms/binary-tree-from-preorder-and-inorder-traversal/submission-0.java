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
    HashMap<Integer, Integer> map = new HashMap<>();
    int preind = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) return null;

        int nodeval = preorder[preind];
        preind++;
        TreeNode node = new TreeNode(nodeval);
        

        int mid = map.get(nodeval);
        
        node.left = dfs(preorder, l, mid - 1);
        node.right = dfs(preorder, mid + 1, r);

        return node;
    }
}
/*
always when split things use (left and right)---IMP---

take the first ind in preorder lets call it root
go to root in inorder array

find the first ind in pre order(maybe loop, or )


*/