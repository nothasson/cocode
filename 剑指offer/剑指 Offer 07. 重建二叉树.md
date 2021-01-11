https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```



这题大三就做过了,一直不会啊..现在终于会了,找准下表对应关系就好了

![image-20210111142221353](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210111142221353.png)

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        TreeNode temp;
        int i = 0;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) break;
        }
        temp = new TreeNode(inorder[i]);
        temp.left = buildTree(preorder, inorder, preStart + 1, i + preStart - inStart, inStart, i - 1);
        temp.right = buildTree(preorder, inorder, i + preStart - inStart + 1, preEnd, i + 1, inEnd);
        return temp;
    }
}
```

当然效率也不是特别高的.

![image-20210111143442963](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210111143442963.png)

此外有迭代实现的思路https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/4chong-jie-fa-di-gui-zhan-dui-lie-by-sdwwld/