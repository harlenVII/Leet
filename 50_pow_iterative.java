public void myPow(double x, int n) {
    double result = 1;
    while (n > 0) {
        if ((n & 1) == 1) {
            result *= x;
        }
        
        x *= x;
        n >>= 1;
    }
    
    return result;
}
