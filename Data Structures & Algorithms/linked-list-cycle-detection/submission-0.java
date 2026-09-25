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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        return hasCycle(head.next, head.next.next);
    }

    private boolean hasCycle(ListNode slow, ListNode fast) {
        if (fast == null || fast.next == null) {
            return false;
        }

        if (slow == fast) {
            return true;
        } else {
            return hasCycle(slow.next, fast.next.next);
        }

    }
}
