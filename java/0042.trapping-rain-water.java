// 求得左右局部最高点，然后求得局部最高点的重合部分即可
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int len = height.length;
        int[] left_max=new int[len];
        int[] right_max=new int[len];
        left_max[0] = height[0];
        for (int i = 1; i < len; ++i) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 0; i < len; ++i) {
            ans += Math.min(right_max[i], left_max[i])-height[i];
        }
        return ans;
    }
}

// 使用栈
class Solution{
    public int trap(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) { // 栈中放入的是比栈底小的数
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }
}

// 双指针 较小的局部最大值和当前值的差一定可能装水
class Solution{
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax=0, rightMax = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                --right;
            } else {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                ++left;
            }
        }
        return ans;
    }
}