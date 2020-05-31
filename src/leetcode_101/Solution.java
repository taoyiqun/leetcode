package leetcode_101;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirro(root,root);
    }
    public boolean isMirro(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left != null && right != null){
            return left.val == right.val && isMirro(left.left,right.right) && isMirro(left.right,right.left);
        }else{
            return false;
        }
    }
}