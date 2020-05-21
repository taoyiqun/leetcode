package leetcode_5;

public class Solution {
    public String longestPalindrome(String s) {
        //动态规划dp[i][j]表示i-j是否构成回文串
        if(s == null || s.length() == 0){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = -1;
        int start = 0;
        int end = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if(j - i == 1){
                    dp[i][j] = (s.charAt(j) == s.charAt(i));
                }else if(i == j){
                    dp[i][j] = true;
                }else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(j) == s.charAt(i));
                }
                if(dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start,end+1);
    }
}
