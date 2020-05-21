package leetcode_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //前序遍历 dfs
/*    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int rank = 0;
        Order(root,res,rank);
        return res;
    }
    public static void Order(TreeNode node,List<List<Integer>> lists,int rank){
        if(node != null){
            if(lists.size() <= rank){
                lists.add(new ArrayList<>());
            }
            lists.get(rank).add(node.val);
            rank = rank + 1;
            Order(node.left,lists,rank);
            Order(node.right,lists,rank);
        }
    }*/
    //后序便利
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        List<TreeNode> queen = new ArrayList<>();
        TreeNode now;
        int size = 0;
        queen.add(root);
        levelList.add(root.val);
        res.add(levelList);
        while (!queen.isEmpty()){
            size = queen.size();
            levelList = new ArrayList<>();
            while (size > 0){
                now = queen.get(0);
                queen.remove(0);
                if(now.left != null){
                    queen.add(now.left);
                    levelList.add(now.left.val);
                }
                if(now.right != null){
                    queen.add(now.right);
                    levelList.add(now.right.val);
                }
                size--;
            }
            if(!levelList.isEmpty()){
                res.add(levelList);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(treeNode3);
        System.out.println(lists);
    }

}
