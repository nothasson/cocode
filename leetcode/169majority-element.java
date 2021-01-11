class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else if (count <= 0) {
                count = 0;
                major = nums[i];
            } else count--;
        }
        count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == major)count++;
        }
        if(count>nums.length/2)return major;
        return -1;
    }
}