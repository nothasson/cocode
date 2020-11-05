class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = ((start + end + 1) / 2);
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = helper(nums, start, mid - 1);
        newNode.right = helper(nums, mid + 1, end);
        return newNode;
    }
}