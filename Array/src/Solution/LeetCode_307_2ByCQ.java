package Solution;

/**
 * Created by Administrator on 2019/2/28.
 */
public class LeetCode_307_2ByCQ {
    private SegmentTree<Integer> segmentTree;

    public LeetCode_307_2ByCQ(int[] nums){

        if (nums.length>0){
            Integer[] data = new Integer[nums.length];
            for (int i=0;i<nums.length;i++){
                data[i] = nums[i];
            }

            segmentTree = new SegmentTree<Integer>(data, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a+b;
                }
            });
        }
    }

    public void update(int i, int val) {
        segmentTree.set(i,val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i,j);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-4,5,-1,6};
        LeetCode_307_2ByCQ leetCode3072ByCQ = new LeetCode_307_2ByCQ(arr);
        System.out.println(leetCode3072ByCQ.sumRange(1,3));
        System.out.println(leetCode3072ByCQ.sumRange(0,2));
        System.out.println(leetCode3072ByCQ.sumRange(3,5));
        leetCode3072ByCQ.update(3,-3);
        System.out.println(leetCode3072ByCQ.sumRange(3,5));
    }
}
