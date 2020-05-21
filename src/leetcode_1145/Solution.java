package leetcode_1145;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//图中的联通分量可以用并查集
//树中的联通分量用dfs
public class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode treeNode = dfs(root,x);
        int countLeft = 0;
        int countRight = 0;
        countLeft = countTreeNode(treeNode.left,0);
        countRight = countTreeNode(treeNode.right,0);
        int count = n - 1 - countLeft - countRight;
        return countLeft > n/2 || countRight > n/2 || count > n/2;
    }

    public static TreeNode dfs(TreeNode treeNode,int x){
        if(treeNode == null){
            return null;
        }
        if(treeNode.val == x){
            return treeNode;
        }
        TreeNode left = dfs(treeNode.left,x);
        TreeNode right = dfs(treeNode.right,x);
        return  (left != null)? left:right;
    }

    public static int countTreeNode(TreeNode treeNode,int count){
        if(treeNode == null){
            return count;
        }
        count++;
        count = countTreeNode(treeNode.left,count);
        count = countTreeNode(treeNode.right,count);
        return count;
    }

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 11; i++){
            list.add(i);
        }
        TreeNode treeNode = TreeNode.constructTreeNode(list);
        TreeNode treeNode1 = dfs(treeNode,6);
        int n = countTreeNode(treeNode1,0);
        System.out.println();
    }
}
