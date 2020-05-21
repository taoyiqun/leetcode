package leetcode_560;

import java.util.HashMap;

public class Solution {
    //暴力遍历
   /* public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length;i++){
            sum = nums[i];
            if(sum == k){
                res++;
            }
            for (int j = i+1; j < nums.length;j++){
                sum = sum + nums[j];
                if(sum == k){
                    res++;
                }
            }
        }
        return res;
    }*/
    //前缀和，存和为value的个数
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int num : nums){
            sum = sum + num;

            if(map.get(sum - k) != null){
                count = count + map.get(sum - k);
            }

            if(sum == k){
                count++;
            }
            if(map.get(sum) == null){
                map.put(sum,1);
            }else {
                map.put(sum,map.get(sum)+1);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.subarraySum(new int[]{1},0);
        System.out.println(res);
    }
}
