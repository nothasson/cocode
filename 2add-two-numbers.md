>  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
>
> 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
>
> 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```



自己先写了一种方法，一开始没注意到空指针的问题，需要将新生成的节点赋值到一个临点上，再将这个临时节点赋值给遍历节点的下一个值。

虽然实现了功能吧，但是好像时间空间复杂度都很低。可能是遍历了两次。先贴代码。

```java
class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val + l2.val);
        ListNode p1 = l1.next, p2 = l2.next, p3 = result;
        ListNode temp;
        while (p1 != null && p2 != null) {
            temp = new ListNode(p1.val + p2.val); //注意
            p1 = p1.next;
            p2 = p2.next;
            p3.next = temp;
            p3 = p3.next;
        }
        if (p1 == null)
            p1 = p2;

        while (p1 != null) {
            temp = new ListNode(p1.val);  //注意
            p3.next = temp;
            p3 = p3.next;
            p1 = p1.next;
        }
        p3 = result;
        while (p3 != null && p3.next != null) {
            if (p3.val >= 10) {
                p3.val -= 10;
                p3.next.val++;
            }
            p3 = p3.next;
        }

        if (p3.val >= 10) {
            p3.val -= 10;
            p3.next = new ListNode(1);
        }
        return result;
    }
}
```



然后我改了一下，复杂度降低了很多。。我以为有什么高级的算法。

```java
        if (p1 == null)
            p1 = p2;

        while (p1 != null) {
            temp = new ListNode(p1.val);  //注意
            p3.next = temp;
            p3 = p3.next;
            p1 = p1.next;
        }
```



```java
if (p1 == null)
	p1 = p2;
	p3.next = p1;
```



然后看了一下别人的题解，发现别人把进位的操作提前做了。也没有使用新的链，而是直接拿了l1当结果链表。结果和我的差不多吧。

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
```



