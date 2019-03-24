package Solution;

import Queue.LinkedListQueueByCQ;

/**
 * Created by Administrator on 2019/2/18.
 */
public class LinkedListSolutionByCQ {

    public ListNode delNum(ListNode head,int val){
        //删除链表开始的重复数字
        while (head!=null && head.val==val){
            head = head.next;
        }
        if (head == null){
            return head;
        }

//        ListNode prve = head;
//        ListNode cur = head.next;
//        while(cur!=null){
//            if (cur.val==val){
//                prve.next=cur.next;
//                cur = cur.next;
//            }else{
//                prve = prve.next;
//                cur = cur.next;
//            }
//        }
        ListNode prve = head;
        while (prve.next != null){
            if (prve.next.val == val){
                prve.next = prve.next.next;
            }else{
                prve = prve.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,4};
        ListNode listNode = new ListNode(arr);
        ListNode listNodeNew = new LinkedListSolutionByCQ().delNum(listNode,1);
        System.out.println(listNodeNew);
    }
}
