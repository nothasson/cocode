import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int left = 0, right = n - 1, up = 0, down = m - 1, index = 0;
        while (true) {
            index = left;
            while (index <= right)
                res.add(matrix[up][index++]);
            if (++up > down) break;
            index = up;
            while (index <= down)
                res.add(matrix[index++][right]);
            if (--right < left) break;
            index = right;
            while (index >= left)
                res.add(matrix[down][index--]);
            if (--down < up) break;
            index = down;
            while (index >= up)
                res.add(matrix[index--][left]);
            if (++left > right) break;
        }
        return res;
    }
}