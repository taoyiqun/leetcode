package leetcode_221;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int res = solution.maximalSquare(new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1'1,'1','1','1'},{'1','0','0','1','0'}});
//        int res = solution.maximalSquare(new char[][] {{'1'}});
        int res = solution.maximalSquare(new char[][] {{'0','1'}});
        System.out.println(res);
    }
}
