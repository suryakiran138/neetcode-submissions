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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode res = new ListNode();
        res.next = list1.val>=list2.val ? list1 : list2;
        ListNode l1=list1,l2=list2,tmp=res;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                tmp.next = l1;
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        if(l1==null) tmp.next = l2;
        else tmp.next = l1; 
        return res.next;
    }
}