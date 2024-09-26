public class LeetCode05_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //1.先求出需要逆序多少组n
        int length = 0;
        ListNode tmp = head;
        while(tmp != null){
            tmp = tmp.next;
            length++;
        }
        int n = length / k;
        //2.重复n次，长度为k的链表即可（逆序可以使用双指针，也可以使用头插法）
        ListNode cur = head;//记录要翻转的节点
        ListNode newHead = new ListNode();//新的头节点
        ListNode prev = new ListNode();//需要记录每一组逆序中的第一个节点位置
        tmp = newHead;
        for(int i = 0;i < n;i++){
            //这里使用头插法
            prev = cur;
            for(int j = 1;j <= k;j++){

                ListNode curNext = cur.next;
                cur.next = tmp.next;
                tmp.next = cur;
                cur = curNext;
            }
            tmp = prev;
        }

        //3.把不需要翻转的接入到链表中
        tmp.next = cur;
        return newHead.next;
    }
}
