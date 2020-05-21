package leetcode_236;

import java.util.Stack;

public class Solution {
    private Boolean finished = false;
    //寻找路径的方法
    public void findPath(TreeNode root,TreeNode searchnode,Stack<TreeNode> path){
        if(root == null || this.finished){
            return;
        }
        path.push(root);
        if(root.val == searchnode.val){
            this.finished = true;
            return;
        }
        findPath(root.left,searchnode,path);
        findPath(root.right,searchnode,path);
        if(!finished){
            path.pop();
        }
    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Stack<TreeNode> p_path = new Stack<>();
//        Stack<TreeNode> q_path = new Stack<>();
//        this.finished = false;
//        this.findPath(root,p,p_path);
//        this.finished = false;
//        this.findPath(root,q,q_path);
//        int lev = Math.min(p_path.size(),q_path.size());
//        TreeNode res = root;
//        for (int i = 0; i < lev;i++){
//            if(p_path.get(i)==q_path.get(i)){
//                res = p_path.elementAt(i);
//            }
//        }
//        return res;
//    }
    //前序遍历的方法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }else if(left == null){
            return right;
        }else {
            return left;
        }

    }


    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        Solution solution = new Solution();
        TreeNode res = solution.lowestCommonAncestor(treeNode3,treeNode5,treeNode4);
        System.out.println(res.val);


    }
}
