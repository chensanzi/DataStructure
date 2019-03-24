package Solution;

/**
 * Created by Administrator on 2019/1/31.
 *
 *  * 删除链表中重复的数(用递归解决问题)
 */
public class LinkedListSolution3 {
    /**
     *
     * @param head
     * @param val
     * @param depth 递归深度
     * @return
     */
    public ListNode removeElements(ListNode head,int val,int depth){

        String depthString = generateDepthString(depth);
        System.out.println(depthString);
        System.out.println("Call:remove"+val+"in"+head);

        if (head == null){
            System.out.print(depthString);
            System.out.print("Return:"+head);
            return head;
        }

////        ListNode res = removeElements(head.next,val);
////        if (head.val == val){
////            return res;
////        }else{
////            head.next = res;
////            return head;
////        }

//        head.next = removeElements(head.next,val,depth+1);
//        return head.val == val ? head.next:head;

        ListNode res = removeElements(head.next,val,depth+1);
        System.out.println(depthString);
        System.out.println("After remover"+val+":"+res);

        ListNode ret;
        if (head.val == val){
            ret = res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.println(depthString);
        System.out.println("Return:"+ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i=0;i<depth;i++){
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LinkedListSolution3()).removeElements(head,6,0);
        System.out.println(res);
    }
}
