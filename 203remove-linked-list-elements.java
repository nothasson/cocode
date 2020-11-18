class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode cur = dumpy;
        while(cur!=null){
            if(cur.next!=null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        return dumpy.next;
    }
}