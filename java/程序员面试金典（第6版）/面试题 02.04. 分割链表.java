/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode q = head;
        ListNode p = head.next;

        while (p != null) {
            if (p.val < x) {
                q.next = p.next;

                p.next = head;
                head = p;
                p = q.next;
            } else {
                q = p;
                p = p.next;
            }
            
        }
        return head;
    }
}