/**
https://leetcode.com/problems/intersection-of-two-linked-lists/
Write a program to find the node at which the intersection of two singly linked lists begins.
Input Format:
        8
        [4,1,8,4,5]
        [5,0,1,8,4,5]
        2
        3
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//compare reference not val. val doesnt mean anything here! use == not equalto

/**两个stacks, 从后往前倒序push到stack再peek*/
时间 O （max(n,m)）
空间 O （n+m）

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode res = null;
        Stack<ListNode> listA = new Stack<>();
        Stack<ListNode> listB = new Stack<>();
        ListNode curA = headA;
        ListNode curB = headB;

        while(curA != null){
            listA.push(curA);
            curA = curA.next;
        }
        while(curB != null){
            listB.push(curB);
            curB = curB.next;
        }
        if(listA.peek().val != listB.peek().val){
            return null;
        }

        while(!listA.isEmpty() && ! listB.isEmpty() && listA.peek() == listB.peek()){
            res = listA.peek();
            listA.pop();
            listB.pop();
        }
        return res;

    }
}


/**把a append到b后面，b append到a后面使他们长度相等。
如果有intersection则出wile loop条件为curA==curB，如果没有出loop的条件是curA==curB==null*/

时间 O （n+m）
空间 O （1）

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        while(curA != curB){
            curA = curA==null? headB:curA.next;
            curB = curB==null? headA:curB.next;
        }
        return curA;
    }
}

