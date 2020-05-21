package leetcode_80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 1;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i - 1] != nums[j]){
                nums[i] = nums[j];
                i++;
                count = 1;
            }else {
                if(count == 1){
                    nums[i] = nums[j];
                    i++;
                    count++;
                }
            }
        }
        return i;
    }
}
