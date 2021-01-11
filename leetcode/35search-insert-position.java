// 昨天被老师嫌弃了 有点尴尬，可能也是因为才第一周，不放心我做项目吧。加油
class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
}