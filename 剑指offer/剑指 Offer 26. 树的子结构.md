

#### [剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

       3
      / \
     4   5
      / \
     1   2
    给定的树 B：

```
    4 
  /
 1
```

返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

```
输入：A = [1,2,3], B = [3,1]
输出：false
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
```

两次遍历，第一次遍历先遍历出开始的节点，第二次遍历开始比较。

先从根节点判断B是不是A的子结构，如果不是在分别从左右两个子树判断。只有有一个节点符合条件，结果就是正确的。

```java
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return checkSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean checkSub(TreeNode A, TreeNode B) {
        //B已经访问完了，确定是A的子结构
        if (B == null)
            return true;
        //如果B不为空A为空，或者这两个节点值不同，说明B树不是A的子结构，直接返回false
        if (A == null || A.val != B.val)
            return false;
        return checkSub(A.left, B.left) && checkSub(A.right, B.right);
    }
}
```