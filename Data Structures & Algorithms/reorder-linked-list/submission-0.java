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
    public void reorderList(ListNode head) {
        //finding middle element
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow=dummy,fast=dummy;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next=null;
        Stack<ListNode> stack = new Stack<>();
        while(l2!=null){
            stack.push(l2);
            l2=l2.next;
        }

        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            ListNode temp = l1.next;
            l1.next = node;
            node.next = temp;
            l1 = temp;
        }
    }
}
