class Solution {
    public void moveZeroes(int[] nums) {
        int zeros = 0;
        int i=0;
        for(;i<nums.length;i++){
            if(nums[i] == 0) zeros++;
            else{
                nums[i - zeros] = nums[i];
            }
        }
        for(i = nums.length-zeros;i<nums.length;i++)
            nums[i] = 0;
    }
}