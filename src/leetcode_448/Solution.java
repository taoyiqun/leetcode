package leetcode_448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        //Arrays.fill(flag,false);
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            flag[num-1] = true;
        }
        for (int i = 0;i < nums.length;i++){
            if(!flag[i]){
                res.add(i+1);
            }
        }
        return res;
    }
}
