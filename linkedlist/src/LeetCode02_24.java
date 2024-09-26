public class LeetCode02_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        if(head == null || head.next == null){
            return head;
        }
        //定义四个指针分别指向需要交换的节点以及节点两边关联的节点
        ListNode prev = newHead,
                cur = prev.next,next = cur.next,nnext = next.next;
        while(cur != null &&  next != null){
            //交换,因为每个节点的位置已经存好了，所以交换的顺序可以随意
            prev.next = next;
            next.next = cur;
            cur.next = nnext;
            //换好之后四个指针向后移动
            prev = cur;
            cur = nnext;
            //需要判定是否为空
            if(cur != null)
                next = cur.next;
            if(next != null)
                nnext = next.next;
        }
        //经过交换之后头节点发生了变化，所以直接返回新定义的头节点
        return newHead.next;
    }
}
