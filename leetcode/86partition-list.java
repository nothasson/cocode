//善用伪头节点。
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode biggerHead = new ListNode(-1);
        ListNode smallerHead = new ListNode(-1);
        ListNode bigger = biggerHead, smaller = smallerHead;
        while (head != null) {
            if (head.val >= x) {
                bigger.next = head;
                bigger = bigger.next;
            } else {
                smaller.next = head;
                smaller = smaller.next;
            }
            head = head.next;
        }
        bigger.next = null;
        smaller.next = biggerHead.next;
        return smallerHead.next;
    }
}