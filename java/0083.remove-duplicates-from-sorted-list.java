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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode i = head, j = head.next;
        while(j != null){
            while(j != null && i.val == j.val){
                i.next = j.next;
                j = j.next;
            }
            i = i.next;
            if(j != null){
                j = j.next;
            }
        }
        return head;
    }
}