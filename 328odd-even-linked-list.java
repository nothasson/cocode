class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddStart = head, evenStart = oddStart.next;
        ListNode odd = oddStart, even = evenStart;
        while (even != null && even.next != null) {
            ListNode temp = even.next;
            even.next = temp.next;
            temp.next = evenStart;
            odd.next = temp;
            odd = temp;
            even = even.next;
        }
        return head;
    }
}