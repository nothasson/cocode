class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0) return res;
        backtracking(candidates, 0, target, res, new LinkedList<>());
        return res;
    }

    private void backtracking(int[] candidates, int begin, int target, List<List<Integer>> res,
                              List<Integer> nowList) {
        if (target == 0) {
            List<Integer> now = new LinkedList<>(nowList);
            res.add(now);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target < candidates[i]) continue;
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            nowList.add(candidates[i]);
            backtracking(candidates, i + 1, target - candidates[i], res, nowList);
            nowList.remove(nowList.size() - 1);
        }
    }
}