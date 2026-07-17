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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0, head);
        ListNode groupPrev=res,curr=head;
        while(true){
            ListNode kth = getKthNode(groupPrev,k);
            if(kth==null) break;
            ListNode groupNext = kth.next;

            ListNode prev=kth.next;
            curr = groupPrev.next;
            while(curr!=groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode tmp = groupPrev.next; 
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return res.next;
        
    }

    private ListNode getKthNode(ListNode curr, int k){
        while(curr!=null && k>0){
            curr = curr.next;
            k=k-1;
        }
        return curr;
    }
}
