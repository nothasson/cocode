  先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了

![image-20201014212137539](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20201014212137539.png)

这是最容易的方法了

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.left != null) stack.add(temp.left);
            if (temp.right != null) stack.add(temp.right);
        }
        Collections.reverse(result);
        return result;
    }
}
```



~~很久之前看过一种方法就是模拟递归的，写的非常巧妙。但是目前找不到了。等找到了之后再放上来吧。~~

当我没说，发现超时了