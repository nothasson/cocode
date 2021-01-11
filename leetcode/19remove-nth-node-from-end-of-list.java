class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        ListNode dummpy = new ListNode(-1);
        ListNode fast = head, slow = head;
        dummpy.next = head;
        ListNode slowPre = dummpy;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            slowPre = slowPre.next;
        }
        slowPre.next = slow.next;
        return dummpy.next;
    }
}