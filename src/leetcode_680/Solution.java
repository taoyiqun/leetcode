package leetcode_680;

public class Solution {
    public boolean validPalindrome(String s) {
        boolean flag = false;
        int start = 0;
        int end = s.length() - 1;
        while (start < end){
            if(s.charAt(start) == s.charAt(end)){
                start ++;
                end --;
            }else {
                if(s.charAt(start + 1) == s.charAt(end)){
                    if(validindrome(s.substring(start+1,end+1))){
                        return true;
                    }
                }
                if(s.charAt(end - 1) == s.charAt(start)) {
                    return validindrome(s.substring(start, end));
                }
                return false;
            }
        }
        return true;
    }
    public boolean validindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while (start < end){
            if(s.charAt(start) == s.charAt(end)){
                start ++;
                end --;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean ans = solution.validPalindrome("abc");
        System.out.println(ans);
    }
}
