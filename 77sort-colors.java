class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1, index = 0;
        while (index <= two) {
            if (nums[index] == 1)  //不操作，
                index++;
            else if (nums[index] == 0) {  //如果是0的话，则移到最前面
                int tmp = nums[index];
                nums[index] = nums[zero];
                nums[zero] = tmp;
                zero++;
                index++;
            } else if (index <= two && nums[index] == 2) {  //二的时候只交换，交换回来的是什么后面的循环再做判断
                int tmp = nums[index];
                nums[index] = nums[two];
                nums[two] = tmp;
                two--;
            }
        }
    }
}