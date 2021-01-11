class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        backtracking(nums, 0,  res);
        return res;
    }

    private void backtracking(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> temp = new LinkedList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            backtracking(nums, i + 1, res);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}