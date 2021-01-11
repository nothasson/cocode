一开始直接拿了108题的做法，只是将题目给的链表转为了数组。

```java
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        int[] nums = new int[length];
        p = head;
        length = 0;
        while (p != null) {
            nums[length++] = p.val;
            p = p.next;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = ((start + end + 1) / 2);
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = helper(nums, start, mid - 1);
        newNode.right = helper(nums, mid + 1, end);
        return newNode;
    }
}
```



这样发现有些不太厚道。所以看了下别人的回答。（不过速度已经很快了，只是牺牲了O(n)的空间而已）



##　快慢指针求重点

这个就是完全模仿数组的操作了，只是指针和数组求中值的方法不太相同

```java
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

将找中值的函数直接嵌入到buildTree中将会快很多.

```java
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //边界条件的判断
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        //这里通过快慢指针找到链表的中间结点slow，pre就是中间
        //结点slow的前一个结点
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表断开为两部分，一部分是node的左子节点，一部分是node
        //的右子节点
        pre.next = null;
        //node就是当前节点
        TreeNode node = new TreeNode(slow.val);
        //从head节点到pre节点是node左子树的节点
        node.left = sortedListToBST(head);
        //从slow.next到链表的末尾是node的右子树的结点
        node.right = sortedListToBST(slow.next);
        return node;
    }
}
```

