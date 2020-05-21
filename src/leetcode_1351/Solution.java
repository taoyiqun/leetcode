package leetcode_1351;

public class Solution {
    public int countNegatives(int[][] grid) {
        int start = 0;
        int count = 0;
        for (int i = grid.length-1; i >= 0; i--) {
            for (int j = start; j < grid[0].length; j++) {
                if(grid[i][j] < 0){
                    count = count + grid[0].length - j;
                    start = j;
                    break;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

    }
}
