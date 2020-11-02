//太久没写了啊，这几周作业剧增
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;

        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = left;
                    curNode.right = right;
                    list.add(curNode);
                }
            }
        }
        return list;
    }
}