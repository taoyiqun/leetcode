package leetcode_1354;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    //模拟的方法失败
/*    public boolean isPossible(int[] target) {
        if(target.length < 2){
            return target.length == 0 || target[0] == 1;
        }
        int[] res = new int[2];
        res = isEnd(target);
        while (res[1] != -1){
            if(target[res[1]] > res[0] && res[0] != 1){
                target[res[1]] = target[res[1]]%res[0];
            }else if(res[0] == 1){
                return true;
            }else {
                target[res[1]] = target[res[1]] - res[0];
            }
            if(target[res[1]] <= 0){
                return false;
            }
            res = isEnd(target);
        }
        return true;
    }
    public int[] isEnd(int[] target){
        int max = 0;
        boolean flag = true;
        int sum = 0;
        int[] res = new int[2];
        for (int i = 0; i < target.length; i++) {
            if(target[i] > target[max]){
                max = i;
            }
            if (target[i] != 1) {
                flag = false;
            }
            sum = sum + target[i];
        }
        res[0] = sum-target[max];
        if(!flag){
            res[1] = max;
        }else {
            res[1] = -1;
        }
        return res;
    }*/

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.isPossible(new int[]{2}));
    }
}
