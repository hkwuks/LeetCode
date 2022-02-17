/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = 1;
        ListNode p = head;
        while(p.next != null) {
            ++len;
            p = p.next;
        }
        int add = len - k % len;
        if(add == len){
            return head;
        }
        p.next=head;

        while(add-- > 0){
            p=p.next;
        }
        ListNode res = p.next;
        p.next = null;
        return res;
    }
}