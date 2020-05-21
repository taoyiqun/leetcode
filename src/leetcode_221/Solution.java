package leetcode_221;

public class Solution {
    //暴力
//    public int maximalSquare(char[][] matrix) {
//        if(matrix.length == 0){
//            return 0;
//        }
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int res = 0;
//        for (int i = 0;i < row;i++){
//            int[] sum = new int[col];
//            for (int j = i;j < row; j++){
//                for(int k = 0;k < col; k++){
//                    if(matrix[j][k] == '1'){
//                        sum[k]++;
//                    }
//                }
//                res = Math.max(res,getMaxEdgeLength(sum,j-i+1));
//            }
//        }
//        return res;
//    }
    public static int getMaxEdgeLength(int[] sum,int edgeLen){
        int count = 0;
        for (int i = 0; i < sum.length;i++){
            if(sum[i] == edgeLen){
                count++;
            }else {
                count = 0;
            }
            if(count == edgeLen){
                return count*count;
            }
        }
        return 0;
    }
    //pd 动态规划 pd存
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int[][] pd = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0;i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1') {
                    if(i == 0 || j == 0){
                        pd[i][j] = 1;
                    }else {
                        pd[i][j] = Math.min(pd[i-1][j-1],Math.min(pd[i-1][j],pd[i][j-1]))+1;
                    }
                    res = Math.max(pd[i][j],res);
                }
            }
        }
        return res*res;
    }
}