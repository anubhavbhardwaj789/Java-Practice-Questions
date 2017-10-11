////////////////////////////////////////////////////////////////////////////////////////////
/*

PROBLEM STATEMENT:
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

SOURCE: Leetcode

Difficulty Level : Medium

Author: Anubhav Bhardwaj

*/
/////////////////////////////////////////////////////////////////////////////////////////////

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode x=l1;
        ListNode y=l2;
        int carry=0;
        ListNode res=new ListNode(0);
        ListNode temp=res;
         while(x!=null||y!=null)
         {
             res.val=(((x!=null)?x.val:0)+((y!=null)?y.val:0)+carry)%10;
             carry=(((x!=null)?x.val:0)+((y!=null)?y.val:0)+carry)/10;
             if(x!=null)x=x.next;
             if(y!=null)y=y.next;
             if(x!=null||y!=null)
             {
                 res.next=new ListNode(0);
                 res=res.next;
             }
         }
        if(carry!=0)
            res.next=new ListNode(carry);
        return temp;
    }
}