/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode next = dummpy.next;  //遍历该排序的
        ListNode pre = dummpy;
        ListNode cur;  // 遍历替换位置的

        while (next != null) {
            cur = dummpy;
            while (cur.next.val < next.val && cur.next != next) {
                cur = cur.next;
            }
            if (cur.next != next) {
                pre.next = next.next;
                next.next = cur.next;
                cur.next = next;

                next = pre.next;
            } else {
                next = next.next;
                pre = pre.next;
            }

        }

        return dummpy.next;
    }
}