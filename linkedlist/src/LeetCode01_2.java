
public class LeetCode01_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //使用链表模拟两数相加的操作，在用一个变量存放每个进位相加后的结果
        ListNode head = new ListNode(0);//随便给个值
        ListNode tmpHead = head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int tmp = 0;
        while(cur1 != null || cur2 != null || tmp != 0){
            if(cur1 != null){
                tmp += cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                tmp += cur2.val;
                cur2 = cur2.next;
            }
            ListNode node = new ListNode(tmp % 10);
            tmpHead.next = node;
            tmpHead = tmpHead.next;
            tmp /= 10;

        }
        return head.next;
    }
}
