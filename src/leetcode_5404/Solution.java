package leetcode_5404;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        int count = 0;
        List<String> strings = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if(target[count] == i){
                strings.add("Push");
                count++;
            }else {
                strings.add("Push");
                strings.add("Pop");
            }
            if(count == target.length){
                break;
            }
        }
        return strings;
    }
}
