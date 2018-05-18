/**
 *
 *   leetCode ：203删除链表中的元素
 *
 *   题目：删除链表中等于给定值val的所有元素
 *   示列
 *   给定：1-->2-->6-->3-->4-->5-->6 , val = 6;
 *   返回：1-->2-->3-->4-->5
 *
 */


public class Solution {


    //使用头标记head实现
    public ListNode removeElements01(ListNode head, int val) {

        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode = null;
        }

        if(head == null)
            return head;

        ListNode prev = head;      //此时head肯定不为空，且head.val的值肯定不为val;

        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode = null;
            }else{
                prev = prev.next;
            }

        }
        return head;
    }



    //使用虚拟节点实现
    public ListNode removeElements02(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

}

