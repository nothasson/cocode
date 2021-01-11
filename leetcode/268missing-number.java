class Solution {
    public int missingNumber(int[] nums) {
        int num = nums.length;
        for (int i = 0; i < nums.length; i++) {
            num += i;
            num -= nums[i];
        }
        return num;
    }
}