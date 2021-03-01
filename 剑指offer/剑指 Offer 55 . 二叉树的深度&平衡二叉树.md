#### [剑指 Offer 55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)

输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

```
    3
   / \
  9  20
    /  \
   15   7
-------------
返回3
```

这题还是不难的。

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = root.left == null ? 0 : maxDepth(root.left);
        int r = root.right == null ? 0 : maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}
```

顺便要回忆一下二叉树的序列化和反序列过程https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/

#### [剑指 Offer 55 - II. 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/)

输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

```
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回true
---------------------------------------
给定二叉树 [1,2,2,3,3,null,null,4,4]
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 返回false
```

**自底向上**

思路是对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。

算法流程：
recur(root) 函数：

返回值：

- 当节点root 左 / 右子树的深度差 $≤1$ ：则返回当前子树的深度，即节点 root 的左 / 右子树的深度最大值 +1 （ max(left, right) + 1 ）；

- 当节点root 左 / 右子树的深度差 >2 ：则返回 -1 ，代表 此子树不是平衡树 。

终止条件：

- 当 root 为空：说明越过叶节点，因此返回高度 00 ；
- 当左（右）子树深度为 −1 ：代表此树的 左（右）子树 不是平衡树，因此剪枝，直接返回 -1−1 ；

isBalanced(root) 函数：

返回值： 若 recur(root) != -1 ，则说明此树平衡，返回 true； 

否则返回 false 。

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
```



**自顶向下**

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
```

