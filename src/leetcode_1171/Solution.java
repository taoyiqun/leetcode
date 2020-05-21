package leetcode_1171;


import leetcode_1171.ListNode;

import java.util.*;

//注意审题

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        head = listNode;
        HashMap<Integer,ListNode> map = new HashMap<>();
        int sum = 0;
        while (listNode != null){
            sum = sum + listNode.val;
            map.put(sum,listNode);
            listNode = listNode.next;
        }
        sum = 0;
        listNode = head;
        while (listNode != null){
            sum = sum + listNode.val;
            listNode.next = map.get(sum).next;
            listNode = listNode.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        head.next = listNode1;
        ListNode listNode2 = new ListNode(-3);
        listNode1.next = listNode2;
        listNode1 = listNode2;
        listNode2 = new ListNode(3);
        listNode1.next = listNode2;
        listNode1 = listNode2;
        listNode1.next = new ListNode(1);
        Solution solution = new Solution();
        head = solution.removeZeroSumSublists(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
