#### [剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

![image-20210128114534937](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210128114534937.png)

```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

```

## 主要思想:

先遍历两条链表获取对应的长度a,b,然后让长的链表先走a-b步,最后一起遍历,每次遍历判断是否相等即可

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength=0,bLength = 0;
        ListNode cur1 = headA,cur2 = headB;
        while(cur1!=null){
            aLength++;
            cur1 = cur1.next;
        }
        while(cur2!=null){
            bLength++;
            cur2 = cur2.next;
        }
        if(bLength > aLength){
            cur1 = headA;
            headA = headB;
            headB = cur1;
        }
        cur1 = headA;
        cur2 = headB;
        int minus = bLength > aLength?bLength-aLength:aLength-bLength;
        while(minus!=0){
            cur1 = cur1.next;
            minus--;
        }
        while(cur1!=null && cur2!=null){
            if(cur1 == cur2)return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
```

