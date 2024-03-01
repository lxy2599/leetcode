/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
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
        ListNode l1_ptr = l1;
        ListNode l2_ptr = l2;
        int carry = 0;
        ListNode head = new ListNode();
        ListNode p = head; 
        while(l1_ptr != null && l2_ptr != null){
            ListNode node = new ListNode();
            if(l1_ptr.val + l2_ptr.val + carry >= 10){
                p.next = new ListNode(l1_ptr.val + l2_ptr.val + carry - 10);
                carry = 1;
            }else{
                p.next = new ListNode(l1_ptr.val + l2_ptr.val + carry);
                carry = 0;
            }
            p = p.next;
            l1_ptr = l1_ptr.next;
            l2_ptr = l2_ptr.next;
        }

        if(l1_ptr != null){
            while(l1_ptr != null){
                if(l1_ptr.val + carry >= 10){
                    p.next = new ListNode(l1_ptr.val + carry - 10);
                    carry = 1;
                }else{
                    p.next = new ListNode(l1_ptr.val + carry);
                    carry = 0;
                }
                p = p.next;
                l1_ptr = l1_ptr.next;
            }
        }

        if(l2_ptr != null){
            while(l2_ptr != null){
                if(l2_ptr.val + carry >= 10){
                    p.next = new ListNode(l2_ptr.val + carry - 10);
                    carry = 1;
                }else{
                    p.next = new ListNode(l2_ptr.val + carry);
                    carry = 0;
                }
                p = p.next;
                l2_ptr = l2_ptr.next;
            }
        }

        if(carry == 1)
            p.next = new ListNode(1);

        return head.next;
    }
}
// @lc code=end

