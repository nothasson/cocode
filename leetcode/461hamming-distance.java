class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (x == 0 && y == 0) break;
            if ((x & 1) != (y & 1)) result++;
            x >>= 1;
            y >>= 1;
        }
        return result;
    }
}