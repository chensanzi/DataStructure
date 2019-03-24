package Solution;

/**
 * Created by Administrator on 2019/2/18.
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:
 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3

 */
public class LeetCode_83 {
    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
        if (head == null || head.next == null){
            return head;
        }
        ListNode prve = head;
        while(prve.next!=null){
            if (prve.val == prve.next.val){
                prve.next = prve.next.next;
            }else {
                prve = prve.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4};
        ListNode head = new ListNode(arr);
        new LeetCode_83().deleteDuplicates(head);
        System.out.println(head);
    }
}
