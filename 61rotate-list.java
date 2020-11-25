class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode fast = head, slow = head;
        ListNode slowPre = dummpy.next, fastPre = dummpy.next;
        int num = k;
        while (num-- != 0) {
            fast = fast.next;
            if (fast == null) fast = head;
        }
        if (fast == slow) return head;
        while (fast != null) {
            fastPre = fast;
            slowPre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        slowPre.next = null;
        fastPre.next = head;
        return slow;
    }
}
//啊着 1800ms

//做了一点小小的改动，变成1ms了
while (num-- != 0) {
            fast = fast.next;
            length++;
            if (fast == null) {
                fast = head;
                num = num % length;
            }
        }