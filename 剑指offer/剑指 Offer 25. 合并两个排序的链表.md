#### [剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```



创建一个新的链表，把两个链表中小的节点放进来就好了，这样不断迭代，如果其中一个的指针为空了，就把另外一个直接接到后面来。

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) l1 = l2;  //如果l1空了，则把l2赋值给l1
        head.next = l1;  // 这样的话，head.next就是l1和l2中不为空的那一个。
        return dummy.next;
    }
}
```



