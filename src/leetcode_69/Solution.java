package leetcode_69;

public class Solution {
//    //牛顿迭代法 切线
//    public int mySqrt(int x) {
//        double start_x = x;
//        double start_y = start_x * start_x - x;
//        double k = 2 * start_x;
//        double pointcut_x = start_x - start_y/k;
//        while (Math.abs(pointcut_x * pointcut_x -x)>0.00001){
//            start_x = pointcut_x;
//            start_y = start_x * start_x - x;
//            k = 2 * start_x;
//            pointcut_x = start_x - start_y/k;
//        }
//        return (int)pointcut_x;
//
//    }
    //由于小数部分直接去除,可以直接运算 111 10 11
    //二分查找
    public int mySqrt(int x) {
        //用除号保障不为0
        if(x == 0){
            return 0;
        }
        int max = x;
        int min = 1;
        int mid = (max+min)/2;
        while (min <= max){
            //注意mid*mid超过int范围
           if(mid > x/mid){
               max = mid - 1;
           }else if(mid < x/mid){
               min = mid + 1;
           }else {
               return mid;
           }
           mid = (max + min)/2;
        }
        return mid;

    }

}
