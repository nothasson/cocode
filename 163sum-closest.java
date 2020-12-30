class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int newTarget = 0;
        int min = Integer.MAX_VALUE;
        int minAbs = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            newTarget = target - nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int temp = newTarget - nums[l] - nums[r];
                if (minAbs > Math.abs(temp)) {
                    minAbs = Math.abs(temp);
                    min = temp;
                }
                if (temp > 0) l++;
                else if (temp < 0) r--;
                else return target;
            }
        }
        return target - min;
    }
}