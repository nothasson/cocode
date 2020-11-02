我先用了后序的方法，发现这样的结果并不能保证是二叉搜索树，

随后我将每一棵树的最大最小值分别保存之后，有一个值过不了，得用Interger保存，虽然我看了别人中序，那是真的牛皮

```java
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}

```

