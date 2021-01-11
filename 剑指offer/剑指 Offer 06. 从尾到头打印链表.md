https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

```
输入：head = [1,3,2]
输出：[2,3,1]
```
一开始写了个递归的方法，然后效率太低了。。

```java
class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new LinkedList<>();
        if(head == null)return new int[]{};
        getValue(head, res);
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private void getValue(ListNode head, List<Integer> res) {
        if (head.next != null)
            getValue(head.next, res);
        res.add(head.val);
    }
}
```

![image-20210111141224270](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210111141224270.png)

然后递归就是一个栈,所以用了栈的方法写了一次.

```java
class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
    return res;
    }
}
```

![image-20210111141343954](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210111141343954.png)

效率高了很多.

直接顺序输出,然后再逆转结果数组也是可以的.不过效率也是不高