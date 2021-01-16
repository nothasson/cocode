#### [剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

镜像输出：

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

```
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
```

一道后序遍历，从叶子节点开始交换就好了。~

```java
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;  
        if (root.left != null) mirrorTree(root.left);
        if (root.right != null) mirrorTree(root.right);
        TreeNode temp = root.right;  //交换左右节点。
        root.right = root.left;
        root.left = temp;
        return root;
    }
}
```

还有迭代的方法，但是效率上远没有递归的好~

```java
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
```

