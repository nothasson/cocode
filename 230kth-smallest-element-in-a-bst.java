class Solution {
    int count;
    int res;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        this.k = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count++;
        if (count == k) {
            res = root.val;
        }
        helper(root.right);
    }
}