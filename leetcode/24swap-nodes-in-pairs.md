```java
class Solution { // 迭代
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode cur = dummpy;
        ListNode start, end;
        while (cur.next != null && cur.next.next != null) {
            start = cur.next;
            end = cur.next.next;
            cur.next = end;
            start.next = end.next;
            end.next = start;
            cur = start;
        }
        return dummpy.next;
    }
}
```

抄别人的递归

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
```

