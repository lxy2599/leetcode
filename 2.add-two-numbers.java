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
        // 进位
        int carry = 0;
        // 链表头节点
        ListNode head = new ListNode(), p = head; 
        // 只要没有把两个链表遍历完成或者还有进位
        while(l1 != null || l2 != null || carry != 0){
            // 计算进位
            if((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry >= 10){
                p.next = new ListNode((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry - 10);
                carry = 1;
            }else{
                p.next = new ListNode((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry);
                carry = 0;
            }

            // 指针移动
            p = p.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }

        // 返回头节点的下一个节点
        return head.next;
    }
}
// @lc code=end

