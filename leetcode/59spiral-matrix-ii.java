class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int index = 0;
        int left = 0, up = 0, right = n - 1, down = n - 1;
        while (count <= n * n) {
            index = left;
            while (index <= right) {
                res[up][index] = count++;
                index++;
            }
            up++;
            index = up;
            while (index <= down) {
                res[index][right] = count++;
                index++;
            }
            right--;
            index = right;
            while (index >= left ) {
                res[down][index] = count++;
                index--;
            }
            down--;
            index = down;
            while (index >= up ) {
                res[index][left] = count++;
                index--;
            }
            left++;
        }
        return res;
    }
}