class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == INT_MIN && divisor == -1) return INT_MAX;
        if (abs(divisor) == 1) return divisor * dividend;
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor>0)) flag = -1;
        long a = dividend;
        long b = divisor;
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        return flag * div(a, b);
    }

private:
    int div(long a, long b) {
        if (a < b) return 0;
        long tb = b;
        int re = 0;
        int n = 1;
        while (a >= tb + tb) {
            tb += tb;
            n += n;
        }
        re += n;
        re += div(a - tb, b);
        return re;
    }
};