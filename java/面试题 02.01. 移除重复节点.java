/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(head.val);
        ListNode q = head;
        ListNode p = head.next;
        while (p != null) {
            if (set.contains(p.val)) {
                q.next = p.next;
                p = p.next;
                continue;
            }else{
                set.add(p.val);
            }
            q = p;
            p = p.next;
        }
        return head;
    }
}