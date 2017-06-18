public class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double res = myPow(x, n/2);
        System.out.println(1.0 / x * res * res);
        if (n % 2 != 0)
            return n < 0 ? 1.0 / x * res * res : res * res * x;
        else
            return res * res;
    }
}
