class Solution {
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int n0 = 0, n1 = 1,v=0;
        int i = 1;
        while (i != n) {
            v = n0 + n1;
            n0 = n1;
            n1 = v;
            ++i;
        }
        return v;
    }
}