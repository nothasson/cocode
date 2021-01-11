class Solution {
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private int sum = 0;

    public void helper(TreeNode root, int tempSum) {
        if (root == null) return;
        int val = root.val;
        if (root.left == null && root.right == null) {
            sum += (tempSum*10 + val);
        }
        helper(root.left, tempSum * 10 + val);
        helper(root.right, tempSum * 10 + val);

    }
}