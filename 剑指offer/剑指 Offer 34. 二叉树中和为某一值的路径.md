#### [剑指 Offer 34. 二叉树中和为某一值的路径](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

```
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

sum =22
[
   [5,4,11,2],
   [5,8,4,5]
]

```

一道之前大三的时候面试百度问过的题目。。

一道回溯题，虽然自己写的效率不太好

```java
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)return res;
        dfs(root, sum, new LinkedList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        temp.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            res.add(new LinkedList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        if (root.left != null) dfs(root.left, sum - root.val, temp, res);
        if (root.right != null) dfs(root.right, sum - root.val, temp, res);
        temp.remove(temp.size() - 1);
    }
}
```

![image-20210117142109931](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210117142109931.png)

应该是没有剪枝。。不过题解的代码和我的差不多。。