//自己写的，效率不高
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backtracking(res, 1, k, n, new LinkedList<>());
        return res;
    }

    private void backtracking(List<List<Integer>> res, int index, int k, int n, List<Integer> nowList) {
        if (k == 0) {
            res.add(new LinkedList<>(nowList));
            return;
        }
        for (int i = index; i <= n; i++) {
            nowList.add(i);
            backtracking(res, i + 1, k - 1, n, nowList);
            nowList.remove(nowList.size() - 1);
        }
    }
}
//剪枝
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (k <= 0 || n < k) 
            return res;
        backtracking(res, 1, k, n, new LinkedList<>());
        return res;
    }

    private void backtracking(List<List<Integer>> res, int index, int k, int n, List<Integer> nowList) {
        if (k == 0) {
            res.add(new LinkedList<>(nowList));
            return;
        }
        for (int i = index; i <= n - k + 1 ; i++) {
            nowList.add(i);
            backtracking(res, i + 1, k - 1, n, nowList);
            nowList.remove(nowList.size() - 1);

        }
    }
}