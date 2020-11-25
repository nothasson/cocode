```java
//先写了个垃圾算法，击败8%的人。。。
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if (!map.containsKey(cur.val)) map.put(cur.val, 0);
            map.put(cur.val, map.get(cur.val) + 1);
            cur = cur.next;
        }
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        cur = dummpy;
        int num;
        while (cur.next != null) {
            if (map.get(cur.next.val) >= 2) {
                num = map.get(cur.next.val);
                while (num != 0) {
                    cur.next = cur.next.next;
                    num--;
                }
            } else
                cur = cur.next;
        }
        return dummpy.next;
    }
}
//估计也是要用双指针？
```

递归的做法

思路：删除所有头部的重复节点，返回不重复的第一个节点。

1.特殊情况，头节点为null或头节点下一节点为null，直接返回头节点，这时不存在重复节点
2.如果头节点与，头节点的下一节点值相等，跳过所有相等节点。递归调用函数判断最后一个跳过节点的后一节点。
3.如果头节点与，头节点的下一节点值不等，递归调用函数判断头节点的后一节点。

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
```

迭代。。

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head.next;
        while (b != null) {
            if (a.next.val != b.val) {
                a = a.next;
                b = b.next;
            } else {
                while (b != null && a.next.val == b.val) {
                    b = b.next;
                }
                a.next = b;
                //b指针在while中判断完后，可能指向了null，这里需要处理边界问题
                b = (b == null) ? null : b.next;
            }
        }
        return dummy.next;
    }
}
```

