class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> list, List<List<Integer>> res) {
        res.add(new LinkedList<>(list));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1])
                continue;
            list.add(nums[j]);
            dfs(nums, j + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        result.add(empty);
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            int dupCount = 0;
            //判断当前是否是重复数字，并且记录重复的次数
            while (((i + 1) < num.length) && num[i + 1] == num[i]) {
                dupCount++;
                i++;
            }
            int prevNum = result.size();
            //遍历之前几个结果的每个解
            for (int j = 0; j < prevNum; j++) {
                List<Integer> element = new ArrayList<Integer>(result.get(j));
                //每次在上次的结果中多加 1 个重复数字
                for (int t = 0; t <= dupCount; t++) {
                    element.add(num[i]); //加入当前重复的数字
                    result.add(new ArrayList<Integer>(element));
                }
            }
        }
        return result;
    }

}