/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int cnt = 0;
        while (head != null) {
            A[cnt++] = head;
            head = head.next;
        }
        return A[cnt / 2];
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            ++cnt;
            cur = cur.next;
        }
        int i = 0;
        cur = head;
        while (i < cnt / 2) {
            ++i;
            cur = cur.next;
        }
        return cur;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}