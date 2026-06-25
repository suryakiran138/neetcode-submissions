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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        int rem = 0;
        int div = 0;
        while(l1!=null && l2!=null){
            int add = l1.val+l2.val+div;
            rem = add%10;
            div = add/10;
            ListNode node = new ListNode(rem);
            prev.next = node;
            prev = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null && l2==null && div!=0){
            ListNode node1 = new ListNode(div);
            prev.next = node1;
        }
        while(l1!=null){
            int add = l1.val+div;
            rem = add%10;
            div = add/10;
            ListNode node = new ListNode(rem);
            prev.next = node;
            prev = node;
            l1 = l1.next;
            if(l1==null && div!=0){
                ListNode node1 = new ListNode(div);
                prev.next = node1;
            } 
        }
        while(l2!=null){
            int add = l2.val+div;
            rem = add%10;
            div = add/10;
            ListNode node = new ListNode(rem);
            prev.next = node;
            prev = node;
            l2 = l2.next;
            if(l2==null && div!=0){
                ListNode node1 = new ListNode(div);
                prev.next = node1;
            }
        }
        
        return dummy.next;
    }
}
