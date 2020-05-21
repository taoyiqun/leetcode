package leetcode_51;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] path_map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path_map[i][j] = '.';
            }
        }
        List<List<String>> res = new LinkedList<>();
        getAns(path_map,n,res,0);
        return res;
    }
    public void getAns(char[][] path_map,int n,List<List<String>> res,int row){
        if(row == n){
            res.add(toList(path_map));
        }
        for (int col = 0; col < n; col++) {
            if(isBalance(path_map,row,col,n)){
                path_map[row][col] = 'Q';
                getAns(path_map,n,res,row + 1);
                path_map[row][col] = '.';
            }
        }
    }
    public List<String> toList(char[][] path_map){
        StringBuilder sb = null;
        List<String> res = new LinkedList<>();
        for (char[] chars : path_map) {
            sb = new StringBuilder();
            for (int j = 0; j < path_map[0].length; j++) {
                sb.append(chars[j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
    public boolean isBalance(char[][] path_map,int row, int col,int n){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if(path_map[i][j] == 'Q' && (col == j || Math.abs(j - col) == Math.abs(i - row))){
                    return false;
                }
            }
        }
        return true;
    }
}
