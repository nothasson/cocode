class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        int tempSum = 0;
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            tempSum = target - nums[i];  
            for (int j = i + 1; j < len; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    int sum = nums[j] + nums[l] + nums[r];
                    if (sum == tempSum) {  //满足条件
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum < tempSum) l++;
                    else r--;
                }
            }
        }
        return res;
    }
}