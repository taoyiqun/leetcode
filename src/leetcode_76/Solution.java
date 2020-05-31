package leetcode_76;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int sLen = s.length();
        int tLen = t.length();
        int min = Integer.MAX_VALUE;
        int min_start = 0;
        int min_end = -1;
        char c;
        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            c = t.charAt(i);
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }
        while (end < sLen){
            c = s.charAt(end);
            sMap.put(c,sMap.getOrDefault(c,0)+1);
            if(isStandard(sMap,tMap)){
                if(end - start + 1 < min){
                    min_start = start;
                    min_end = end;
                    min = end - start + 1;
                }
                c = s.charAt(start);
                if(sMap.containsKey(c)){
                    sMap.put(c,sMap.get(c)-1);
                }
                start++;
                while (isStandard(sMap,tMap)){
                    c = s.charAt(start);
                    if(sMap.containsKey(c)){
                        sMap.put(c,sMap.get(c)-1);
                    }
                    start++;
                }
                if((end - start + 2 )< min){
                    min_start = start-1;
                    min_end = end;
                    min = end - start + 2;
                }
            }
            end++;
        }
        return s.substring(min_start,min_end+1);
    }
    public boolean isStandard(Map<Character,Integer> sMap,Map<Character,Integer> tMap){
        for (Map.Entry<Character,Integer> entry: tMap.entrySet()){
            if(!sMap.containsKey(entry.getKey())){
                return false;
            }else if(sMap.get(entry.getKey()) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.minWindow("a", "aa");
        System.out.println(s);
    }
}
