package leetcode_684;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] nums = new int[1100];
        int[] rank = new int[1100];
        for(int[] edge:edges){
            int root1 = findRoot(edge[0],nums);
            int root2 = findRoot(edge[1],nums);
            if (root1 != root2){
                if(rank[root1]>rank[root2]){
                    nums[root2] = root1;
                }else if(rank[root1]<rank[root2]){
                    nums[root1] = root2;
                }else {
                    nums[root2] = root1;
                    rank[root1]++;
                }
            }else {
                return edge;
            }
        }
        return null;
    }
    public static int findRoot(int x,int[] nums){
        while (nums[x] != 0){
            x = nums[x];
        }
        return x;
    }
}