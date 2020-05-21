package leetcode_50;

public class Solution {
// (a+b)%c = (a%c + b%c)%c
// (a-b)%c = (a%c - b%c)%c
// (a*b)%c = (a%c * b%c)%c
    //快速幂算法
    public double myPow(double x, int n) {
        double res = 1;
        boolean flag = true;
        if (n == 0){
            return 1;
        }else if(n < 0){
            n = -n;
            flag = false;
        }
        while (n != 0){
            if(n % 2 == 0){
                n = n/2;
                x = x * x;
            }else {
                res = res * x;
                n = n/2;
                x = x * x;
            }
        }
        if(flag){
            return res;
        }else {
            return 1.0/res;
        }
    }
}
