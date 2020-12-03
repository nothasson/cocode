class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(nums, 0, nums.length - 1),
                myRob(nums, 1, nums.length));
    }

    private int myRob(int[] nums, int start, int end) {
        int pre = 0, cur = 0, tmp;
        for (int i = start; i < end; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        return cur;
    }
}
//进行两次198的操作，一次不取第一个，一次不取最后一个，最后取两个之间最大的那个