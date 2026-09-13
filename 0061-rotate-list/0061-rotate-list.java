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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;int count=0;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        if(k%(++count)==0) return head;

        temp.next=head; // a ring
        ListNode temp2=head;
        int rotate = count-(k%count);
        while(rotate>1){
            rotate--;
            temp2=temp2.next;
        }

        head=temp2.next;
        temp2.next=null;
        return head;

        
    }
}