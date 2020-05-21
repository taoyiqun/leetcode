package leetcode_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    //未优化
//    public int lengthOfLongestSubstring(String s) {
//        //特例之类的首先想到
//        if (s.length()==0) return 0;
//        Map<Character,Integer> hashMap = new HashMap();
//        int i = 0;
//        int j = 0;
//        int pro = 0;
//        int res = 0;
//        int final_res = 0;
//        for ( i = 0 ;i < s.length(); i++){
//            if(hashMap.get(s.charAt(i)) == null){
//                hashMap.put(s.charAt(i),i);
//                res++;
//            }else {
//                pro = hashMap.get(s.charAt(i));
//                for (;j <= pro;j++){
//                    hashMap.remove(s.charAt(j),j);
//                }
//                hashMap.put(s.charAt(i),i);
//                res = i - j + 1;
//            }
//            final_res = Math.max(res,final_res);
//        }
//        return final_res;
//    }
    //时间优化
    public int lengthOfLongestSubstring(String s) {
        //特例之类的首先想到
        if (s.length()==0) return 0;
        Map<Character,Integer> hashMap = new HashMap();
        int i = 0;
        int j = 0;
        int final_res = 0;
        for ( i = 0 ;i < s.length(); i++){
            if(hashMap.containsKey(s.charAt(i)) && hashMap.get(s.charAt(i)) >= j){
                j = hashMap.get(s.charAt(i)) + 1;
                hashMap.put(s.charAt(i),i);
            }else {
                hashMap.put(s.charAt(i),i);
            }
            final_res = Math.max(final_res,i-j+1);
        }
        return final_res;
    }

}
