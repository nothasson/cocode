class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[i] < nums[mid] && nums[j] < nums[mid]) {
                i = mid + 1;
            } else if (nums[i] > nums[mid] && nums[j] > nums[mid]) {
                j = mid;
            } else {
                int min = nums[i];
                for (int k = i; k <= j; k++) {
                    if (nums[k] < min) min = nums[k];
                }
                return min;
            }
        }
        return nums[i];
    }
}