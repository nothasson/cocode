//用一个set保存已经在数组里的数。
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
//        Arrays.sort(nums);
        if (nums == null || nums.length == 0) return res;
        backtracking(nums, 0, res);
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
        HashSet<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (set.contains(nums[j]))
                continue;
            set.add(nums[j]);
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