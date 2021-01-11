//就很诡异。。。，系统默认加了6，导致我错了很多次。。。
class Solution {
  public int countNodes(TreeNode root) {
    return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
  }
}