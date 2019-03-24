package Solution;

/**
 * Created by Administrator on 2019/2/28.
 */
public class LeetCode_303CyCQ {
    private SegmentTree<Integer> segmentTree;
    public LeetCode_303CyCQ(Integer[] arr){
        segmentTree = new SegmentTree<Integer>(arr, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
    }
    public int sumRange(int i,int j){
        return segmentTree.query(i,j);
    }

    public static void main(String[] args) {
        Integer[] arr= {-1,2,3,4,-6,7};
        LeetCode_303CyCQ segmentTree = new LeetCode_303CyCQ(arr);
        System.out.println(segmentTree.toString());
        System.out.println(segmentTree.sumRange(1,2));
        System.out.println(segmentTree.sumRange(0,2));
        System.out.println(segmentTree.sumRange(4,5));
        System.out.println(segmentTree.sumRange(3,5));
    }
}
