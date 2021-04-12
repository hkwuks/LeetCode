// 单指针法
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int tmp = nums[p];
                nums[p] = nums[i];
                nums[i] = tmp;
                ++p;
            }
        }
        for (int i = p; i < n; i++) {
            if (nums[i] == 1) {
                int tmp = nums[p];
                nums[p] = nums[i];
                nums[i] = tmp;
                ++p;
            }
        }
    }
}

// 双指针法
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p = 0, q = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                if (p < q) {
                    tmp = nums[i];
                    nums[i]=nums[q];
                    nums[q] = tmp;
                }
                ++p;
                ++q;
            } else if (nums[i] == 1) {
                int tmp = nums[q];
                nums[q] = nums[i];
                nums[i] = tmp;
                ++q;
            }
        }
    }
}

// 双指针法
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p1 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                --p2;
            }
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                ++p1;
            }
        }
    }
}