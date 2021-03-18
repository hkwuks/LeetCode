class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        // Arrays.sort(intervals,new Comparator<int[]>(){
        //     public int compare(int[] interval1,int[] interval2){
        //         return interval1[0]-interval2[0];
        //     }
        // });
        Arrays.sort(intervals,Comparator.comparing(a->a[0]));
        int len = intervals.length;
        List<int[]> res=new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (res.size() == 0 || res.get(res.size()-1)[1] < L) {
                res.add(new int[] { L, R });
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals,Comparator.comparing(a -> a[0]));
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < len;) {
            int tmp = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= tmp) {
                tmp = Math.max(tmp, intervals[j][1]);
                ++j;
            }
            res.add(new int[] { intervals[i][0], tmp });
            i = j;
        }
        return res.toArray(new int[res.size()][]);
    }
}