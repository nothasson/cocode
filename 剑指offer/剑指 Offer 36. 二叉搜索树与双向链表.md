#### [剑指 Offer 36. 二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

为了让您更好地理解问题，以下面的二叉搜索树为例：

<img src="https://gitee.com/20162180090/piccgo/raw/master/pic/bstdlloriginalbst.png" alt="img" style="zoom:50%;" />

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

<img src="https://gitee.com/20162180090/piccgo/raw/master/pic/bstdllreturndll.png" alt="img" style="zoom:50%;" />

https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/



一个中序遍历的题目，如果是中序遍历，就可以保证节点有有序的，这个时候拿一个pre来记录上一个节点，用来做当前节点的前驱节点。

最后操作头节点head。

```java
class Solution {
    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        //进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,是头节点,head的左节点在主函数中操作了
        if (pre == null)
            head = cur;
        else
            pre.right = cur; //否则的话，pre的右侧就是cur，cur的左侧是pre
        cur.left = pre;
        //更新pre
        pre = cur;
        dfs(cur.right);
    }
}
```

