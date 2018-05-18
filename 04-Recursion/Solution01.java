/**
 * 使用递归解决solution中的问题
 */

public class Solution01 {

    public ListNode removeElements(ListNode head , int val){

        if(head == null)
            return null;                                       // 1）求解最基本问题

        ListNode res = removeElements(head.next , val);         // 2）把原问题转化成最小的问题

        if(head.val == val){
            return res;
        }else{
            head.next = res;
            return head;
        }

/*
        head.next = removeElements(head.next , val);
        return head.val == val ? head.next : head ;
*/
    }
}
