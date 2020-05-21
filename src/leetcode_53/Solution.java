package leetcode_53;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max_num = nums[0];
        int ans = max_num;
        for (int i = 1; i < nums.length; i++) {
            max_num = Math.max(nums[i],nums[i] + max_num);
            ans = Math.max(max_num,ans);
        }
        return ans;

    }
}
