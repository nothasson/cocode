//https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            spare = spare + gas[i] - cost[i];
            if (spare < min) {
                min = spare;
                minIndex = i;
            }
        }
        return spare >= 0 ? (minIndex + 1)%gas.length : -1;
    }
}