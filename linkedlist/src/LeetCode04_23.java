public class LeetCode04_23 {
    /*public ListNode mergeKLists(ListNode[] lists) {
        //1.使用优先级队列创建小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1,v2)->v1.val - v2.val);

        //2.把所有的头节点放进小根堆中
        for(ListNode head : lists){
            if(head != null){
                heap.offer(head);
            }
        }

        //3.比较，将小的节点放到一个新的链表中，并合并
        ListNode newHead = new ListNode();
        ListNode tmp = newHead;
        //队列不能为空
        while(! heap.isEmpty()){
            ListNode ret = heap.poll();
            tmp.next = ret;
            tmp = ret;
            if(ret.next != null){
                heap.offer(ret.next);
            }
        }
        return newHead.next;
    }*/

    public ListNode mergeKLists(ListNode[] lists) {
        //使用分治-递归
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int left,int right){
        //处理边界情况
        if(left > right)
            return null;
        if( left == right)
            return lists[left];
        //1.将数组一分为二
        int mid = (left + right)/2;

        //2.
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);

        //3.合并两个有序链表
        return mergeTwoListNode( l1, l2);

    }

    public ListNode mergeTwoListNode(ListNode l1,ListNode l2){
        ListNode ret = new ListNode();
        ListNode tmp = ret;
        ListNode cur1 = l1,cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                tmp.next = cur1;
                tmp = cur1;
                cur1 = cur1.next;
            }else{
                tmp.next = cur2;
                tmp = cur2;
                cur2 = cur2.next;
            }

        }
        if(cur1 != null){
            tmp.next = cur1;
        }
        if(cur2 != null){
            tmp.next = cur2;
        }
        return ret.next;
    }
}
