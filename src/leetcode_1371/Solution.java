package leetcode_1371;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //状态未压缩，用数组存储当前遍历到各个元音个数
    //储存当前元音奇偶状态首次出现位置
    public int findTheLongestSubstring(String s) {
        int[][] count = new int[2][5];//记录元音字母奇偶性第一次出现位置 初始为-1 0行为偶1行为奇
        int[][] des = new int[s.length()][5];//记录当前位置元音字母出现个数
        int[] status = new int[5];//des[i]
        int ans = 0;
        int[] res = new int[5];
        char letter;
        int index;
        int start;
        Arrays.fill(count[0],-1);
        Arrays.fill(count[1],-1);
        Map<Character,Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('o',1);
        map.put('e',2);
        map.put('i',3);
        map.put('u',4);
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);
            if(map.containsKey(letter)){
                index = map.get(letter);
                status[index] = (status[index] + 1)%2;
                des[i][index]++;
                start = count[status[index]][index] + 1;
                boolean flag = true;
                for (int j = 0; j < 5; j++) {
                    res[j] = des[i][j] - des[start][j];
                    if(res[j]%2 != 0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    ans = Math.max(ans,i - start + 1);
                }
                if(count[status[index]][index] == -1){
                    count[status[index]][index] = i;
                }
            }else {
                if(i > 0){
                    des[i] = Arrays.copyOf(des[i - 1], 5);
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.findTheLongestSubstring("leetcodeisgreat");
        System.out.println(i);
    }
}
