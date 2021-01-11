public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static TreeNode buildTree(int[] nums) {
        return build(nums, 0);
    }

    private static TreeNode build(int[] nums, int index) {
        if (index >= nums.length || nums[index] == 0) return null;
        TreeNode node = new TreeNode(nums[index]);
        node.left = build(nums, 2 * index + 1);
        node.right = build(nums, 2 * index + 2);
        return node;
    }
}