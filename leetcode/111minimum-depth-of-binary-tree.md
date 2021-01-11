一种非递归的方法，感觉速度很慢，有点假，按理说应该比递归快才对。

```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        int depth = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return depth;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            depth++;
        }
        return depth;
    }
}
```

另一种是递归的方法，不知道为什么，同样很慢。

```java
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if(root.left != null) {
            ans = Math.min(minDepth(root.left), ans);
        }
        if(root.right != null) {
            ans = Math.min(minDepth(root.right), ans);
        }
        return ans + 1;
    }
}
```

~~应该是网速太慢了吧。~~

是网站有问题，复制NO1的速度也和我的差不多。