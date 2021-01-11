//虽然速度不是特别快，还是可以接受的
class Solution {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> cur = new LinkedList<>();
        helper(root, sum, cur);
        return result;
    }

    public void helper(TreeNode root, int sum, List<Integer> cur) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> thisResult = new LinkedList<>(cur);
                Collections.copy(thisResult, cur);
                result.add(thisResult);
            }
        }
        helper(root.left, sum - root.val, cur);
        helper(root.right, sum - root.val, cur);
        cur.remove(cur.size() - 1);
    }
}

// 别人100%的代码，基本上是衣杨的，做了一些小改动
class Solution{
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(root, sum, new ArrayList<>(), result);
    return result;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list,List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null)
            return;
        //把当前节点值加入到list中
        list.add(new Integer(root.val));
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null) {
            //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
            //要把它放到result中
            if (sum == root.val)
                result.add(new ArrayList(list));
            //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
            //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
            //一个结点的值给remove掉。
            list.remove(list.size() - 1);
            //到叶子节点之后直接返回，因为在往下就走不动了
            return;
        }
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
        //下一步的时候，sum值要减去当前节点的值
        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);
        //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        //我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
    }
}