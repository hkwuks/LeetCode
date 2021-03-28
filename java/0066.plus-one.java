class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int tmp = 1;
        for (int i = len - 1; i >= 0; --i) {
            if (digits[i] == 9&&tmp==1) {
                digits[i] = 0;
                tmp = 1;
            } else {
                digits[i] += tmp;
                return digits;
            }
        }
        int[] result = new int[len + 1];
        result[0] = 1;
        return result;
    }
}