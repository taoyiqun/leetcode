package leetcode_25;

public class Solution {
    public void myreverse(ListNode head,ListNode tail){
        ListNode tailnext = tail.next;
        //循环链表的写法
        ListNode next = null;
        ListNode pre = tail.next;
        while (pre != tail){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }



    //妙用头节点减少特判
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode hairNode = new ListNode(-1);
       ListNode preNode = hairNode;
       hairNode.next = head;
       ListNode tail = null;
       ListNode temp = null;
       while (head != null){
           tail = preNode;
           for (int i = 0; i < k; i++) {
               tail = tail.next;
               if(tail == null){
                   return hairNode.next;
               }
           }
           myreverse(head,tail);
           temp = head;
           head = tail;
           tail = temp;
           preNode.next = head;
           preNode = tail;
           head = tail.next;
       }
       return hairNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Solution solution = new Solution();
        ListNode res = solution.reverseKGroup(listNode1,2);
        while (res != null){
            System.out.println(res);
            res = res.next;
        }

    }
}
