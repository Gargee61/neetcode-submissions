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
     public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> que = new PriorityQueue<>(); 
        for(int i=0;i<lists.length;i++){
            ListNode l = lists[i]; 
            while(l!=null) {
                que.offer(l.val); 
                l = l.next;
            }
        }
        ListNode ans = new ListNode(); 
        ListNode tail = ans; 
        while(que.size()>0) {
            ListNode temp = new ListNode(que.poll()); 
            tail.next = temp; 
            tail = temp; 
        }
        return ans.next; 
      
    }
}
