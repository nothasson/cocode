

#### [剑指 Offer 35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

![img](https://gitee.com/20162180090/piccgo/raw/master/pic/e1.png)

```
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
```



![img](https://gitee.com/20162180090/piccgo/raw/master/pic/e2.png)

```
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
```

这道题本质上也是一个深搜和广搜的题目

## DFS

```java
public class Solution {
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>(); //原节点和新节点。

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }
        Node node = new Node(head.val);
        this.visitedHash.put(head, node);
        node.next = this.copyRandomList(head.next); //next和rondom看作是他的两条边
        node.random = this.copyRandomList(head.random);
        return node;
    }
}
```

## BFS



```java
public class Solution {
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node clone = new Node(head.val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        visitedHash.put(head, clone);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.next != null && !visitedHash.containsKey(temp.next)) {
                visitedHash.put(temp.next, new Node(temp.next.val));
                queue.offer(temp.next);
            }
            if (temp.random != null && !visitedHash.containsKey(temp.random)) {
                visitedHash.put(temp.random, new Node(temp.random.val));
                queue.offer(temp.random);
            }
            visitedHash.get(temp).next = visitedHash.get(temp.next);
            visitedHash.get(temp).random = visitedHash.get(temp.random);
        }
        return clone;
    }
}
```



## 原地复制

这个解法好像我大三的时候就看过了。。

1. 复制节点，同时将复制节点链接到原节点后面，如A->B->C 变为 A->A'->B->B'->C->C'。
2. 设置节点random值。
3. 将复制链表从原链表分离。

```java
public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node p = head;
        //让A->B->C变成A->A'->B->B'->C->C'
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        //找每个节点的random点。
        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        //拆分链表
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
}
```

