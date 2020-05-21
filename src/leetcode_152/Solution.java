package leetcode_152;

public class Solution {
    //动态规划的转移可能是从其他地方转移过来的
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max_res = nums[0];
        int min_res = nums[0];
        int res = nums[0];
        int temp;
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(Math.max(nums[i],max_res * nums[i]),min_res * nums[i]);
            min_res = Math.min(Math.min(nums[i],min_res * nums[i]),max_res * nums[i]);
            max_res = temp;
            res = Math.max(max_res,res);
        }
        return res;
    }
}
