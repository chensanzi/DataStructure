//package Solution;
//
///**
// * Created by Administrator on 2019/2/23.
// */
//public class LeetCode_307_2 {
//    private SegmentTree<Integer> segmentTree;
//
//    public LeetCode_303(int[] nums){
//
//        if (nums.length>0){
//            Integer[] data = new Integer[nums.length];
//            for (int i=0;i<nums.length;i++){
//                data[i] = nums[i];
//            }
//            segmentTree = new SegmentTree<Integer>(data,(a, b)->a+b);
//        }
//    }
//
//    public int sumRange(int i,int j){
//        if (segmentTree == null){
//            throw new IllegalArgumentException("Segment Tree is null");
//        }
//        return segmentTree.query(i,j);
//    }
//
//    public void update(int index,int val){
//        if (segmentTree == null){
//            throw new IllegalArgumentException("Segment Tree is null");
//        }
//
//        segmentTree.set(index,val);
//    }
//}
