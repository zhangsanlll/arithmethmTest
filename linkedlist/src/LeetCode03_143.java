public class LeetCode03_143 {
    public static void reorderList(ListNode head) {

        //分三步走
        //1.找到链表的中间节点（双指针）
        ListNode mid = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            mid = mid.next;
            fast = fast.next.next;
        }
        //2.把后面的部分逆序（双指针、头插法）
        ListNode tmpMid = mid;
        ListNode rever = tmpMid.next;
        tmpMid = null;
        while(rever != null){
            ListNode reverNext = rever.next;
            rever.next = tmpMid;
            tmpMid = rever;
            rever = reverNext;
        }



        //3.合并两个链表
        //此时tmpMid在最后一个节点的位置
        ListNode cur1 = head;
        ListNode newHead = new ListNode();
        mid.next = null;
        ListNode prev = newHead;
        ListNode cur2 = tmpMid;
        while(cur1 != null ){
            prev.next = cur1;
            prev = cur1;
            cur1 = cur1.next;

            if(cur2 != null) {
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }

        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = node1;
        reorderList(head);
    }
}
