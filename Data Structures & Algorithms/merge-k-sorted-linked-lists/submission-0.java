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
        //int[] p = new int[lists.length];
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while(true){
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int minIndex = -1; 
            boolean noElementPresent = true;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null && lists[i].val<min.val){
                    min = lists[i];
                    minIndex = i;
                    noElementPresent = false;
                }
            }
            if(noElementPresent) break;
            tmp.next = min;
            tmp = tmp.next;
            lists[minIndex] = lists[minIndex].next;
            tmp.next = null;
        }
        return dummy.next;
    }
}
