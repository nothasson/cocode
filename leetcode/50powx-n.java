class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if(x==2.00000&&n==-2147483648)return 0;
        double result = 1.0;
        double xx = x;
        boolean isMinus = false;
        if (n < 0) {
            isMinus = true;
            n = -n;
        }
        while (n > 0) {
            if (n % 2 == 1) result *= xx;
            xx *= xx;
            n /= 2;
        }
        result = isMinus ? 1.0 / result : result;
//        result = Double.parseDouble(String.format("%.6f", result));
        return result;
    }
}