package leetcode_2;
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        ListNode newNode;
        while (l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            newNode =new  ListNode(sum);
            res.next = newNode;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            sum = l1.val + carry;
            carry = sum/10;
            sum = sum%10;
            newNode =new  ListNode(sum);
            res.next = newNode;
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null){
            sum = l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            newNode =new  ListNode(sum);
            res.next = newNode;
            res = res.next;
            l2 = l2.next;
        }
        if(carry != 0){
            newNode = new ListNode(carry);
            res.next = newNode;
            res = res.next;
        }
        head = head.next;
        return head;

    }
}