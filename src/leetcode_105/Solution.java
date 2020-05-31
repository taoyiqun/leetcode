package leetcode_105;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int count = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(preorder[0] == inorder[i]){
                count = i;
            }
        }
        int[] preorder_left = Arrays.copyOfRange(preorder,1,count+1);
        int[] inorder_left = Arrays.copyOfRange(inorder,0,count);
        int[] preorder_right = Arrays.copyOfRange(preorder,count+1,preorder.length);
        int[] inorder_right = Arrays.copyOfRange(inorder,count+1,inorder.length);
        root.left = buildTree(preorder_left,inorder_left);
        root.right = buildTree(preorder_right,inorder_right);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode buildTree = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(buildTree);
    }
}
