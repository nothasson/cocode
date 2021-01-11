//防止重复取值，所以遍历的时候要从i开始
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
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
            nowList.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], res, nowList);
            nowList.remove(nowList.size() - 1);
        }
    }
}