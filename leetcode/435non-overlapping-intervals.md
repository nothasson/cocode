```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= end) {
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
```

![1](pics/435non-overlapping-intervals/678752f150168fc2e53a36d30e589b76ef81a95943c018b01bef6a548bfafeeb-file_1566313617208)

又是看了东哥的

https://leetcode-cn.com/problems/non-overlapping-intervals/solution/tan-xin-suan-fa-zhi-qu-jian-diao-du-wen-ti-by-labu/

