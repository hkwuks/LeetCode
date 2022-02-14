import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (right < interval[0]) {
                // 在左侧
                if (!placed) {
                    ansList.add(new int[] { left, right });
                    placed = true;
                }
                ansList.add(interval);
            } else if (left > interval[1]) {
                // 在右侧
                ansList.add(interval);
            } else {
                // 有交集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        
        if (!placed) {
            ansList.add(new int[] { left, right });
        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}