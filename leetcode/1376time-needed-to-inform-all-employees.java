//自底向上
class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 过滤非叶子节点
            if (informTime[i] != 0) continue;
            // 自下而上从叶子节点员工出发
            int sum = 0, cur = i;
            while (manager[cur] != -1) {
                sum += informTime[manager[cur]];
                cur = manager[cur];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}