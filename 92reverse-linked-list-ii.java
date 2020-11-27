class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n - m < 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode firstPre = dummy;
        int i = 1;
        while (i != m) {
            firstPre = firstPre.next;
            i++;
        }
        ListNode cur = firstPre.next;
        while (i != n) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = firstPre.next;
            firstPre.next = temp;

            i++;
        }
        return dummy.next;
    }
}