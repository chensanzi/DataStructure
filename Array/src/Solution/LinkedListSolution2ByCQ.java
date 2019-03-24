package Solution;

/**
 * Created by Administrator on 2019/2/18.
 */
public class LinkedListSolution2ByCQ {

  public ListNode delNum(ListNode head,int val){
      ListNode dummyNode = new ListNode(-1);
      dummyNode.next = head;

      ListNode prve = dummyNode;
      while (prve.next!=null){
          if (prve.next.val == val){
              prve.next = prve.next.next;
          }else{
              prve = prve.next;
          }
      }
    return dummyNode.next;
  }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,4};
        ListNode listNode = new ListNode(arr);
//        ListNode listNodeNew = new Solution.LinkedListSolution2ByCQ().delNum(listNode,1);
//        System.out.println(listNodeNew);
    }
}
