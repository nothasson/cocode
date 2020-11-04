//好像作业还是可以应付的。。，
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postoder, int postStart, int postEnd) {
        if (postStart > postEnd) return null;
        int val = postoder[postEnd];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        TreeNode cur = new TreeNode(val);
        cur.left = helper(inorder, inStart, index - 1, postoder, postStart, index - 1 - inStart + postStart);
        cur.right = helper(inorder, index + 1, inEnd, postoder, index - inStart + postStart, postEnd - 1);
        return cur;
    }
}