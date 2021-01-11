class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtracking(nums, res, 0, nums.length, new LinkedList<>());
        return res;

    }

    private void backtracking(int[] nums, List<List<Integer>> res, int index, int n, List<Integer> nowList) {
        if (index <= n) {
            res.add(new LinkedList<>(nowList));
        } else return;
        for (int i = index; i < n; i++) {
            nowList.add(nums[i]);
            backtracking(nums, res, i + 1, n, nowList);
            nowList.remove(nowList.size() - 1);
        }
    }
}