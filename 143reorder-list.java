import java.util.List;

class Solution {
    public void reorderList(ListNode head) {
        if(head ==null)return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow);
        slow = head;
        ListNode next;
        while (fast != null) {
            next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = next;
            slow = slow.next.next;
        }
        slow.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}