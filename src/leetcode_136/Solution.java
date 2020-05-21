package leetcode_136;

public class Solution {
    //要充分利用已知条件
    //出现两次想到异或运算
    public Integer singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int answer = nums[0];
        for (int i = 1; i < nums.length;i++){
            answer = answer ^ nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.singleNumber(new int[]{1,1,2,2,4});
        System.out.println(i);
    }
}
