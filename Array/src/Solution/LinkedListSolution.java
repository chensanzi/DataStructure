package Solution;

/**
 * Created by Administrator on 2019/1/31.
 *
 * 删除链表中重复的数
 */
public class LinkedListSolution {
    public ListNode removeElements(ListNode head,int val){

        //删除开始部分
        while (head != null && head.val == val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode = null;
            head = head.next;
        }

        if (head == null){
            return null;
        }

        ListNode prev = head;
        while(prev.next != null){
            if (prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode = null;
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        
        ListNode res = (new LinkedListSolution()).removeElements(head,6);
        System.out.println(res);
    }
}
