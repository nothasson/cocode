尴尬，以为是水题，发现还是过不了

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if (root.left == null && root.right == null && sum == root.val)  return true;
        if ((sum < root.val && root.val >0) || (sum > root.val && root.val<0) ) return false;
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}
```

自己写的代码。![image-20201105205619655](pics/112path-sum/image-20201105205619655.png)

狂错。

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
```

发现是自己想偏了