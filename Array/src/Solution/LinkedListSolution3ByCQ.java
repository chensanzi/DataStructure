package Solution;


/**
 * Created by Administrator on 2019/1/31.
 *
 *  * 删除链表中重复的数(递归解决问题)
 */
public class LinkedListSolution3ByCQ {
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
        System.out.println("call remove"+val+" in"+head);


        if (head == null){
            System.out.println(depthString);
            System.out.println("return head:"+head);
            return head;
        }

        ListNode res = removeElements(head.next,val,depth+1);
        System.out.println(depthString);
        System.out.println("After remover"+val+":"+res);

        ListNode ret = null;
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
        StringBuilder str = new StringBuilder();
        for (int i=0;i<depth;i++){
            str.append("--");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new LinkedListSolution3ByCQ()).removeElements(head,6,0);
        System.out.println(res);
    }
}
