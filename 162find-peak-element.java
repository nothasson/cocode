class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int mid = 0;
        while(lo < hi) {
            mid = lo + (hi - mid) / 2;
            if(mid > 0 && nums[mid] <= nums[mid - 1]) {
                hi = mid - 1;
            }else if(mid < nums.length - 1 && nums[mid] <= nums[mid + 1]) {
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return lo;
    }
}