class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mid = search(nums, target);
        if (mid == -1) return new int[]{-1, -1};
        int left = mid, right = mid;
        while (right < nums.length && nums[right] == target)
            right++;
        while (left >= 0 && nums[left] == target)
            left--;
        return new int[]{left + 1, right - 1};
    }

    private int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }
}