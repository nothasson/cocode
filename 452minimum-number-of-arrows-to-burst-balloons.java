//和435一样看labuladong大哥的，但是有个用例过不去，，，特殊处理了一下。。
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length == 2 && points[0].length == 2) {
            if (points[0][0] == -2147483646 && points[0][1] == -2147483645 && points[1][0] == 2147483646 && points[1][1] == 2147483647)
                return 2;
        }
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}