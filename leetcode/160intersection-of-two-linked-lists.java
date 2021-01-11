/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength=0,bLength = 0;
        ListNode cur1 = headA,cur2 = headB;
        while(cur1!=null){
            aLength++;
            cur1 = cur1.next;
        }
        while(cur2!=null){
            bLength++;
            cur2 = cur2.next;
        }
        if(bLength > aLength){
            cur1 = headA;
            headA = headB;
            headB = cur1;
        }
        cur1 = headA;
        cur2 = headB;
        int minus = bLength > aLength?bLength-aLength:aLength-bLength;
        while(minus!=0){
            cur1 = cur1.next;
            minus--;
        }
        while(cur1!=null && cur2!=null){
            if(cur1 == cur2)return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}