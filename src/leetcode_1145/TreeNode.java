package leetcode_1145;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static TreeNode constructTreeNode(List<Integer> list){
        if(list == null || list.size() == 0 || list.get(0) == null){
            return null;
        }
        TreeNode root = new TreeNode(list.get(0));
        list.remove(0);
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode left = null;
        TreeNode right = null;
        while (queue.size() > 0 && list.size() > 0){
            left = new TreeNode(list.get(0));
            queue.get(0).left = left;
            queue.add(left);
            right = new TreeNode(list.get(1));
            queue.get(0).right = right;
            queue.add(right);
            queue.remove(0);
            list.remove(0);
            list.remove(0);
        }
        return root;
    }
}