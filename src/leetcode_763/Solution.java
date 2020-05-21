package leetcode_763;

import java.util.*;

public class Solution {
    /*public List<Integer> partitionLabels(String S) {
        int start;
        List<Set<Character>> sets = new ArrayList<>();
        boolean flag = false;
        int count;
        LinkedList<Integer> list = new LinkedList<>();
        for (char c:S.toCharArray()) {
            if(sets.size() == 0){
                HashSet<Character> hashSet = new HashSet<>();
                hashSet.add(c);
                sets.add(hashSet);
                list.add(1);
            }else {
                flag = false;
                start = 0;
                for (int j = 0; j < sets.size(); j++) {
                    if(sets.get(j).contains(c)){
                        flag = true;
                        start = j;
                        break;
                    }
                }
                if(flag){
                    count = start + 1;
                    Set<Character> characterSet = sets.get(start);
                    Integer nums = list.get(start);
                    while (count < sets.size()){
                        characterSet.addAll(sets.get(count));
                        nums = nums + list.get(count);
                        list.remove(count);
                        sets.remove(count);
                    }
                    list.remove(start);
                    list.add(nums+1);
                }else {
                    HashSet<Character> hashSet = new HashSet<>();
                    hashSet.add(c);
                    sets.add(hashSet);
                    list.add(1);
                }
            }
        }
        return list;
    }*/
    //更优的解法：倒过来想
    //全是小写字母用数组存对应关系
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(Arrays.toString(list.toArray()));

    }
}
