public class Solution {
    public double myPow(double x, int n) {
        if (n == 1 || x == -1)
            return x;
        if (n == 0)
            return 1;
            
        int absN = Math.abs(n);
        double tmp = myPow(x, absN / 2);
        
        if (absN % 2 == 0)
            return n > 0 ? tmp * tmp : 1 / (tmp * tmp);
        else
            return n > 0 ? tmp * tmp * x : 1 / (tmp * tmp * x);
    }
}
