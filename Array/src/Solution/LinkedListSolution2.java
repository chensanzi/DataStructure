package Solution;

/**
 * Created by Administrator on 2019/1/31.
 *
 *  * 删除链表中重复的数(用虚拟头结点解决问题)
 */
public class LinkedListSolution2 {
    public ListNode removeElements(ListNode head,int val){

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LinkedListSolution2()).removeElements(head,6);
        System.out.println(res);
    }
}
